package org.aps.implementations;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

public class Group {
    private final String id;
    private final String name;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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
}
