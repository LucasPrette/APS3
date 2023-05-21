package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.aps.implementations.Biome;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BiomesRepository {
    static final String collection = "biomes";

    public BiomesRepository() {
        new FirebaseService().run();
    }

    public Biome repositoryMapper(DocumentReference ref, DocumentSnapshot document) {
        Map<String, Object> data = document.getData();
        Biome biome = new Biome();

        biome.setRef(ref);

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    biome.setName((String) entry.getValue());
                    break;
                case "id":
                    biome.setId((String) entry.getValue());
                    break;
                default:
                    System.out.println("key not mapped " + entry.getKey());
                    break;
            }
        }

        return biome;
    }

    public Biome repositoryMapper(QueryDocumentSnapshot document) {
        Map<String, Object> data = document.getData();
        Biome biome = new Biome();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    biome.setName((String) entry.getValue());
                    break;
                case "id":
                    biome.setId((String) entry.getValue());
                    break;
                default:
                    System.out.println("key not mapped " + entry.getKey());
                    break;
            }
        }

        return biome;
    }

    public ArrayList<Biome> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<Biome> result = new ArrayList<Biome>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(this.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Biome findByName(String name) {
        try {
            Query query = FirebaseService.repository.collection(collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return this.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Biome findByRef(DocumentReference ref) {
        try {
            return this.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
