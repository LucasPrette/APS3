package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.EndangeredSpecie;
import org.aps.services.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EndangeredSpeciesRepository {
    private final String collection = "endangered_species";
    public EndangeredSpeciesRepository() {
        new Firebase().run();
    }

    public ArrayList<EndangeredSpecie> find() {
        try {
            ApiFuture<QuerySnapshot> query = Firebase.repository.collection(this.collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<EndangeredSpecie> result = new ArrayList<EndangeredSpecie>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(EndangeredSpecie.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public EndangeredSpecie findByName(String name) {
        try {
            Query query = Firebase.repository.collection(this.collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return EndangeredSpecie.repositoryMapper(item);
            }

        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
