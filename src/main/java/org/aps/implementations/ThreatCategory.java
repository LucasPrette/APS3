package org.aps.implementations;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class ThreatCategory {
    private final String id;
    private final String name;
    private final String acronym;

    public ThreatCategory(String id, String name, String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
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

    public static ThreatCategory repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym);
    }

    public static ThreatCategory repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String acronym = document.getString("acronym");
        String id = document.getId();

        return new ThreatCategory(id, name, acronym);
    }
}
