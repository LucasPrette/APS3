package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.ProtectionLevel;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProtectionLevelsRepository {
    private final String collection = "protection_levels";

    public ProtectionLevelsRepository() {
        new Firebase().run();
    }

    public ArrayList<ProtectionLevel> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(this.collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<ProtectionLevel> result = new ArrayList<ProtectionLevel>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(ProtectionLevel.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ProtectionLevel findByName(String name) {
        try {
            Query query = Firebase.repository.collection(this.collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return ProtectionLevel.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ProtectionLevel findByRef(DocumentReference ref) {
        try {
            return ProtectionLevel.repositoryMapper(ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}