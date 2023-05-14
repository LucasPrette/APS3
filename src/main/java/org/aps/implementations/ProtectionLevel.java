package org.aps.implementations;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class ProtectionLevel {
    private final String id;
    private final int level;

    public ProtectionLevel(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public String getId() {
        return this.id;
    }

    public static ProtectionLevel repositoryMapper(QueryDocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level);
    }

    public static ProtectionLevel repositoryMapper(DocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level);
    }
}
