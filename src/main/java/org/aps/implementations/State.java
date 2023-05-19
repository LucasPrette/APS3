package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class State {
    private final String id;
    private final String name;
    private final String uf;
    private DocumentReference ref;

    public State(String id, String name, String uf) {
        this.id = id;
        this.name = name;
        this.uf = uf;
    }

    public State(String id, String name, String uf, DocumentReference ref) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ref = ref;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getUf() {
        return uf;
    }

    public DocumentReference getRef() {
        return ref;
    }

    public static State repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf);
    }

    public static State repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf);
    }

    public static State repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf, ref);
    }

    public static State repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String uf = document.getString("uf");
        String id = document.getId();

        return new State(id, name, uf, ref);
    }
}
