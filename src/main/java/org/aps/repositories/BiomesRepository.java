package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.Biome;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BiomesRepository {
    static final String collection = "biomes";

    public BiomesRepository() {
        new Firebase().run();
    }

    public ArrayList<Biome> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<Biome> result = new ArrayList<Biome>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(Biome.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Biome findByName(String name) {
        try {
            Query query = Firebase.repository.collection(collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return Biome.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public Biome findByRef(DocumentReference ref) {
        try {
            return Biome.repositoryMapper(ref, ref.get().get());
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
