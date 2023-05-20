package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.State;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StatesRepository {
    static final String collection = "states";

    public StatesRepository() {
        new FirebaseService().run();
    }

    public State repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new State(id, name, uf, ref);
    }

    public State repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new State(id, name, uf, ref);
    }

    public State repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf, ref);
    }

    public State repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf, ref);
    }

    public ArrayList<State> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<State> result = new ArrayList<State>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public State findByName(String name) {
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

    public State findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
