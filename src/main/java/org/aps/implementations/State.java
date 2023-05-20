package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class State {
    private String id;
    private String name;
    private final String uf;
    private DocumentReference ref;

    public State(String uf) {
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

    public void setRef(DocumentReference ref) {
        this.ref = ref;
    }
}
