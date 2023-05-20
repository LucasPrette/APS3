package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Group {
    private String id;
    private final String name;
    private DocumentReference ref;

    public Group(String name) {
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

    public void setRef(DocumentReference ref) {
        this.ref = ref;
    }
}
