package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Biome {
    private String id;
    private final String name;
    private DocumentReference ref = null;

    public Biome(String id, String name, DocumentReference ref) {
        this.id = id;
        this.name = name;
        this.ref = ref;
    }

    public Biome(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Biome(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public DocumentReference getRef() {
        return ref;
    }

    public static Biome repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Biome(id, name, ref);
    }

    public static Biome repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Biome(id, name, ref);
    }

    public static Biome repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Biome(id, name);
    }

    public static Biome repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Biome(id, name);
    }
}
