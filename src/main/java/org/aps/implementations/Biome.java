package org.aps.implementations;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Biome {
    private final String id;
    private final String name;

    public Biome(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
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
