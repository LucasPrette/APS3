package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.Type;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TypesRepository {
    static final String collection = "types";

    public TypesRepository() {
        new FirebaseService().run();
    }

    public Type repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Type(id, name, ref);
    }

    public Type repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Type(id, name, ref);
    }

    public Type repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name, ref);
    }

    public Type repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name, ref);
    }

    public ArrayList<Type> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<Type> result = new ArrayList<Type>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Type findByName(String name) {
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

    public Type findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
