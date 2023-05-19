package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.State;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StatesRepository {
    static final String collection = "states";

    public StatesRepository() {
        new Firebase().run();
    }

    public ArrayList<State> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<State> result = new ArrayList<State>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(State.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public State findByName(String name) {
        try {
            Query query = Firebase.repository.collection(collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return State.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public State findByRef(DocumentReference ref) {
        try {
            return State.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
