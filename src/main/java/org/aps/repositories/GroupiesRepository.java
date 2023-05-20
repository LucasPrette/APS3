package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.Group;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GroupiesRepository {
    static final String collection = "groupies";
    public GroupiesRepository() {
        new FirebaseService().run();
    }

    public Group repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Group(id, name, ref);
    }

    public Group repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Group(id, name, ref);
    }

    public Group repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name, ref);
    }

    public Group repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name, ref);
    }

    public ArrayList<Group> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<Group> result = new ArrayList<Group>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Group findByName(String name) {
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

    public Group findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
