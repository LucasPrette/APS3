package org.aps.implementations;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Type {
    private final String id;
    private final String name;

    public Type(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return this.id;
    }

    public static Type repositoryMapper(QueryDocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name);
    }

    public static Type repositoryMapper(DocumentSnapshot document) {
        String name = document.getString("name");
        String id = document.getId();

        return new Type(id, name);
    }
}
