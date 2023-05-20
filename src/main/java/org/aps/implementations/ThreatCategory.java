package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class ThreatCategory {
    private String id;
    private final String name;
    private final String acronym;
    private DocumentReference ref;

    public ThreatCategory(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
    }

    public ThreatCategory(String id, String name, String acronym, DocumentReference ref) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
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

    public static ThreatCategory repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public static ThreatCategory repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();
        DocumentReference ref = document.getReference();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public static ThreatCategory repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym, ref);
    }

    public static ThreatCategory repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym, ref);
    }
}
