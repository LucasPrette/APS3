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
import org.aps.implementations.*;
import org.aps.services.FirebaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class EndangeredSpeciesRepository {
    static final String collection = "endangered_species";
    public EndangeredSpeciesRepository() {
        new FirebaseService().run();
    }
    /**
     * TODO
     * - mainThreats
     */
    private List<EndangeredSpecies> injectRefs(List<EndangeredSpecies> endangeredSpeciesList) {
        // Prefers to get type refs once from Firestore instead of when pre-populating each endangered species
        ArrayList<Type> types = new TypesRepository().findAll();
        ArrayList<Biome> biomes = new BiomesRepository().findAll();
        ArrayList<Group> groups = new GroupiesRepository().findAll();
        ArrayList<State> states = new StatesRepository().findAll();
        ArrayList<ProtectionLevel> protectionLevels = new ProtectionLevelsRepository().findAll();
        ArrayList<ThreatCategory> threatCategories = new ThreatCategoriesRepository().findAll();

        for (EndangeredSpecies endangeredSpecies : endangeredSpeciesList) {
            for (Type type : types) {
                if (type.getName().equals(endangeredSpecies.getType().getName())) {
                    // don't repass all attributes to reduce memory usage
                    endangeredSpecies.getType().setRef(type.getRef());
                }
            }

            for (Biome biome : biomes) {
                for (int i = 0; i < endangeredSpecies.getBiomes().size(); i++) {
                    if (biome.getName().equals(endangeredSpecies.getBiomes().get(i).getName())) {
                        // don't repass all attributes to reduce memory usage
                        endangeredSpecies.getBiomes().get(i).setRef(biome.getRef());
                    }
                }
            }

            for (Group group : groups) {
                if (group.getName().equals(endangeredSpecies.getGroup().getName().toLowerCase())) {
                    // don't repass all attributes to reduce memory usage
                    endangeredSpecies.getGroup().setRef(group.getRef());
                }
            }

            for (State state : states) {
                for (int i = 0; i < endangeredSpecies.getOccurrenceStates().size(); i++) {
                    if (state.getUf().toUpperCase().equals(endangeredSpecies.getOccurrenceStates().get(i).getUf().toUpperCase())) {
                        // don't repass all attributes to reduce memory usage
                        endangeredSpecies.getOccurrenceStates().get(i).setRef(state.getRef());
                    }
                }
            }

            for (ProtectionLevel protectionLevel : protectionLevels) {
                if (protectionLevel.getLevel() == endangeredSpecies.getProtectionLevel().getLevel()) {
                    // don't repass all attributes to reduce memory usage
                    endangeredSpecies.getProtectionLevel().setRef(protectionLevel.getRef());
                }
            }

            for (ThreatCategory threatCategory : threatCategories) {
                if (threatCategory.getAcronym().equals(endangeredSpecies.getThreatCategory().getAcronym())) {
                    // don't repass all attributes to reduce memory usage
                    endangeredSpecies.getThreatCategory().setRef(threatCategory.getRef());
                }
            }
        }

        ArrayList<EndangeredSpecies> result = new ArrayList<EndangeredSpecies>();

        for (EndangeredSpecies current : endangeredSpeciesList) {
            boolean someWithoutRef = current.getType().getRef() == null
                    || current.getBiomes().get(0).getRef() == null
                    || current.getGroup().getRef() == null
                    || current.getOccurrenceStates().get(0).getRef() == null
                    || current.getProtectionLevel().getRef() == null
                    || current.getThreatCategory().getRef() == null;

            if (!someWithoutRef) {
                result.add(current);
            } else {
                System.out.println("======ERROR======");
                System.out.println(current.getFamily());
                System.out.println(current.getName());
                System.out.printf(current.getType().getRef() + " <=>" + current.getType().getName() + "\n");
                System.out.printf(current.getBiomes().get(0).getRef() + "<=>" + current.getBiomes().get(0).getName()  + "\n");
                System.out.printf(current.getGroup().getRef() + "<=>" + current.getGroup().getName()  + "\n");
                System.out.printf(current.getOccurrenceStates().get(0).getRef() + "<=>" + current.getOccurrenceStates().get(0).getUf()  + "\n");
                System.out.printf(current.getProtectionLevel().getRef() + "<=>" + current.getProtectionLevel().getLevel()  + "\n");
                System.out.printf(current.getThreatCategory().getRef() + "<=>" + current.getThreatCategory().getAcronym()  + "\n");
            }
        }

        return result;
    }

    private Map<String, Object> storeMapper(EndangeredSpecies endangeredSpecies) {
        Map<String, Object> result = new HashMap<>();

//        result.put("biome", endangeredSpecies.getBiomes()); // TODO
        result.put("country_exclusive", endangeredSpecies.getCountryExclusive());
        result.put("family", endangeredSpecies.getFamily());
        result.put("fishing_regulation", endangeredSpecies.getFishingRegulation());
        result.put("group", endangeredSpecies.getGroup().getRef()); // TODO
//        result.put("main_threats", endangeredSpecies.getMainThreats()); // TODO
        result.put("name", endangeredSpecies.getName());
//        result.put("occurrence_states", endangeredSpecies.getOccurrenceStates()); // TODO
        result.put("pan", endangeredSpecies.getName());
        result.put("protected_area_presence", endangeredSpecies.getProtectedAreaPresence());
//        result.put("protection_level", endangeredSpecies.getProtectionLevels()); // TODO
        result.put("species", endangeredSpecies.getSpecies());
//        result.put("threat_category", endangeredSpecies.getThreatCategories()); // TODO
        result.put("type", endangeredSpecies.getType().getRef()); // TODO

        return result;
    }

    public void populate(List<EndangeredSpecies> data) {
        try {
//            ArrayList<EndangeredSpecies> uniqueData = new ArrayList<EndangeredSpecies>();
//            QueryDocumentSnapshot docAlreadyExists = FirebaseService.repository.collection(collection).whereEqualTo("name", current.getName()).get().get().getDocuments().get(0);
//
//            if (docAlreadyExists != null) {
//                return;
//            }

            List<EndangeredSpecies> dataWithRefs = this.injectRefs(data);
            System.out.println(dataWithRefs.size());
//            ArrayList<Map<String, Object>> parsedData = new ArrayList<Map<String, Object>>();
//
//            for (EndangeredSpecies dataWithRef : dataWithRefs) {
//                parsedData.add(this.storeMapper(dataWithRef));
//            }
//
//            Firebase.repository.collection(collection).document().set(docData);
        } catch (Exception e) {
//            do nothing
            System.out.println(e.getMessage());
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
