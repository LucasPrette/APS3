package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Group {
    private final String id;
    private final String name;
    private DocumentReference ref;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(String id, String name, DocumentReference ref) {
        this.id = id;
        this.name = name;
        this.ref = ref;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public DocumentReference getRef() {
        return ref;
    }

    public static Group repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name);
    }

    public static Group repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name);
    }

    public static Group repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name, ref);
    }

    public static Group repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Group(id, name, ref);
    }
}
