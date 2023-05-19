/**
 * TODO
 * - verify methods that find in a array of refs or strings
 * - add pagination in search methods
 */
package org.aps.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.aps.implementations.EndangeredSpecies;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EndangeredSpeciesRepository {
    static final String collection = "endangered_species";
    public EndangeredSpeciesRepository() {
        new FirebaseService().run();
    }

    public void populate(ArrayList<EndangeredSpecies> data) {
        EndangeredSpecies current = data.get(0);

        try {
//            QueryDocumentSnapshot docAlreadyExists = Firebase.repository.collection(collection).whereEqualTo("name", current.getName()).get().get().getDocuments().get(0);

//            TODO
//            if (docAlreadyExists != null) {
//
//            }

//            Map<String, Object> docData = new HashMap<>();
//
//            BiomesRepository biomesRepository = new BiomesRepository();

//             ArrayList<DocumentReference> biomesRefs = new ArrayList<DocumentReference>();
//
//             current.getBiomes().forEach(item -> biomesRefs.add(item.getRef()));

//            docData.put("biome", current.getBiomes().fo); // TODO
//            docData.put("country_exclusive", current.getCountryExclusive());
//            docData.put("family", current.getFamily());
//            docData.put("fishing_regulation", current.getFishingRegulation());
//            docData.put("group", current.getGroup()); // TODO
//            docData.put("main_threats", current.getMainThreats()); // TODO
//            docData.put("name", current.getName());
//            docData.put("occurrence_states", current.getOccurrenceStates()); // TODO
//            docData.put("pan", current.getName());
//            docData.put("protected_area_presence", current.getProtectedAreaPresence());
//            docData.put("protection_level", current.getProtectionLevels()); // TODO
//            docData.put("species", current.getSpecies());
//            docData.put("threat_category", current.getThreatCategories()); // TODO
//            docData.put("type", current.getType()); // TODO
//
//            Firebase.repository.collection(collection).document().set(docData);
        } catch (Exception e) {
//            do nothing
        }

        // https://firebase.google.com/docs/firestore/manage-data/add-data
//        https://firebase.google.com/docs/firestore/manage-data/transactions#transactions
//        https://firebase.google.com/docs/firestore/manage-data/transactions#batched-writes
    }

    public ArrayList<EndangeredSpecies> findAll() {
        try {
            ApiFuture<QuerySnapshot> query = FirebaseService.repository.collection(collection).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();

            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            for (QueryDocumentSnapshot document : documents) {
                result.add(EndangeredSpecies.repositoryMapper(document));
            }

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByType(String typeRef) {
        try {
            System.out.println(FirebaseService.repository.collection(TypesRepository.collection).document(typeRef));
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("type", FirebaseService.repository.collection(TypesRepository.collection).document(typeRef));
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByGroup(String groupRef) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("group", FirebaseService.repository.collection(GroupiesRepository.collection).document(groupRef));
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllBySpecie(String specie) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("specie", specie);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByFamily(String family) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("family", family);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByThreatCategory(String threatCategoryRef) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("threat_category", FirebaseService.repository.collection(ThreatCategoriesRepository.collection).document(threatCategoryRef));
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByBiome(String biomeRef) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("biome", FirebaseService.repository.collection(BiomesRepository.collection).document(biomeRef));
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByMainThreats(String mainThreat) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("main_threat", mainThreat);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public ArrayList<EndangeredSpecies> findAllByOccurrenceStates(String occurrenceStatesRef) {
        try {
            Query query = FirebaseService.repository.collectionGroup("endangered_species").whereEqualTo("occurrence_states", FirebaseService.repository.collection(GroupiesRepository.collection).document(occurrenceStatesRef));
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

            list.forEach(item -> result.add(EndangeredSpecies.repositoryMapper(item)));

            return result;
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public EndangeredSpecies findByName(String name) {
        try {
            Query query = FirebaseService.repository.collection(collection).whereEqualTo("name", name).limit(1);
            List<QueryDocumentSnapshot> list = query.get().get().getDocuments();
            QueryDocumentSnapshot item = list.get(0);

            if (item != null) {
                return EndangeredSpecies.repositoryMapper(item);
            }
        } catch (ExecutionException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
