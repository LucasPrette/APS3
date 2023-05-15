package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.ThreatCategory;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ThreatCategoriesRepository {
    private final String collection = "threat_categories";

    public ThreatCategoriesRepository() {
        new Firebase().run();
    }

    public ArrayList<ThreatCategory> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(this.collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<ThreatCategory> result = new ArrayList<ThreatCategory>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(ThreatCategory.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ThreatCategory findByName(String name) {
        try {
            Query query = Firebase.repository.collection(this.collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return ThreatCategory.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ThreatCategory findByRef(DocumentReference ref) {
        try {
            return ThreatCategory.repositoryMapper(ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}