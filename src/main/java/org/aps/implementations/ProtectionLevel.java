package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class ProtectionLevel {
    private String id;
    private final int level;
    private DocumentReference ref;

    public ProtectionLevel(int level) {
        this.level = level;
    }

    public ProtectionLevel(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public ProtectionLevel(String id, int level, DocumentReference ref) {
        this.id = id;
        this.level = level;
        this.ref = ref;
    }

    public int getLevel() {
        return this.level;
    }

    public String getId() {
        return this.id;
    }

    public DocumentReference getRef() {
        return ref;
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

    public static ProtectionLevel repositoryMapper(DocumentReference ref, QueryDocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level, ref);
    }

    public static ProtectionLevel repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        int level = Objects.requireNonNull(document.getLong("level")).intValue();
        String id = document.getId();

        return new ProtectionLevel(id, level, ref);
    }
}
