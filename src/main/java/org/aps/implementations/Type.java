package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Type {
    private String id;
    private final String name;
    private DocumentReference ref;

    public Type(String name) {
        this.name = name;
    }

    public Type(String id, String name, DocumentReference ref) {
        this.id = id;
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return this.id;
    }

    public DocumentReference getRef() {
        return ref;
    }

    public void setRef(DocumentReference ref) {
        this.ref = ref;
    }

    public static Type repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Type(id, name, ref);
    }

    public static Type repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new Type(id, name, ref);
    }

    public static Type repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name, ref);
    }

    public static Type repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name, ref);
    }
}
