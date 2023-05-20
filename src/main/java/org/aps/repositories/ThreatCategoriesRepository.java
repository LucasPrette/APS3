package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.ThreatCategory;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ThreatCategoriesRepository {
    static final String collection = "threat_categories";

    public ThreatCategoriesRepository() {
        new FirebaseService().run();
    }

    public ThreatCategory repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public ThreatCategory repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public ThreatCategory repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public ThreatCategory repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public ArrayList<ThreatCategory> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<ThreatCategory> result = new ArrayList<ThreatCategory>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ThreatCategory findByName(String name) {
        try {
            Query query = FirebaseService.repository.collection(collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return this.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ThreatCategory findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
