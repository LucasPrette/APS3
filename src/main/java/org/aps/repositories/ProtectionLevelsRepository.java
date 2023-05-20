package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.ProtectionLevel;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class ProtectionLevelsRepository {
    static final String collection = "protection_levels";

    public ProtectionLevelsRepository() {
        new FirebaseService().run();
    }

    public ProtectionLevel repositoryMapper(QueryDocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ProtectionLevel(id, level, ref);
    }

    public ProtectionLevel repositoryMapper(DocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ProtectionLevel(id, level, ref);
    }

    public ProtectionLevel repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level, ref);
    }

    public ProtectionLevel repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level, ref);
    }

    public ArrayList<ProtectionLevel> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<ProtectionLevel> result = new ArrayList<ProtectionLevel>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ProtectionLevel findByName(String name) {
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

    public ProtectionLevel findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
