package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.Group;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GroupiesRepository {
    private final String collection = "groupies";
    public GroupiesRepository() {
        new Firebase().run();
    }

    public ArrayList<Group> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(this.collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<Group> result = new ArrayList<Group>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(Group.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Group findByName(String name) {
        try {
            Query query = Firebase.repository.collection(this.collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return Group.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Group findByRef(DocumentReference ref) {
        try {
            return Group.repositoryMapper(ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}