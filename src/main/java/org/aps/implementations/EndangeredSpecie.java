package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.aps.repositories.*;

import java.util.ArrayList;

public class EndangeredSpecie {
    private String id;
    private ArrayList<Biome> biomes;
    private Boolean countryExclusive;
    private String family;
    private boolean fishingRegulation;
    private Group group;
    private ArrayList<String> mainThreats;
    private String name;
    private boolean pan;
    private boolean protectedAreaPresence;
    private ArrayList<ProtectionLevel> protectionLevels;
    private String species;
    private ArrayList<ThreatCategory> threatCategories;
    private Type type;
    private ArrayList<State> occurrenceStates;

    public EndangeredSpecie(
            String id,
            ArrayList<Biome> biomes,
            Boolean countryExclusive,
            String family,
            boolean fishingRegulation,
            Group group,
            ArrayList<String> mainThreats,
            String name,
            boolean pan,
            boolean protectedAreaPresence,
            ArrayList<ProtectionLevel> protectionLevels,
            String species,
            ArrayList<ThreatCategory> threatCategories,
            Type type,
            ArrayList<State> occurrenceStates
    ) {
        this.id = id;
        this.biomes = biomes;
        this.countryExclusive = countryExclusive;
        this.family = family;
        this.fishingRegulation = fishingRegulation;
        this.group = group;
        this.mainThreats = mainThreats;
        this.name = name;
        this.pan = pan;
        this.protectionLevels = protectionLevels;
        this.protectedAreaPresence = protectedAreaPresence;
        this.species = species;
        this.threatCategories = threatCategories;
        this.type = type;
        this.occurrenceStates = occurrenceStates;
    }

    public EndangeredSpecie() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Biome> getBiomes() {
        return biomes;
    }

    public ArrayList<ProtectionLevel> getProtectionLevels() {
        return protectionLevels;
    }

    public String getSpecies() {
        return species;
    }

    public ArrayList<String> getMainThreats() {
        return mainThreats;
    }

    public ArrayList<ThreatCategory> getThreatCategories() {
        return threatCategories;
    }

    public Boolean getCountryExclusive() {
        return countryExclusive;
    }

    public Group getGroup() {
        return group;
    }

    public String getFamily() {
        return family;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<State> getState() {
        return occurrenceStates;
    }

    public boolean getFishingRegulation() { return fishingRegulation; }

    public boolean getPan() { return pan; }

    public boolean getProtectedAreaPresence() { return protectedAreaPresence; }

    public static EndangeredSpecie repositoryMapper(QueryDocumentSnapshot document) {
        ArrayList<DocumentReference> biomesRef = (ArrayList<DocumentReference>) document.get("biome");
        DocumentReference groupRef = (DocumentReference) document.get("group");
        ArrayList<DocumentReference> occurrenceStatesRef = (ArrayList<DocumentReference>) document.get("occurrence_states");
        ArrayList<DocumentReference> protectionLevelsRef = (ArrayList<DocumentReference>) document.get("protection_level");
        ArrayList<DocumentReference> threatCategoriesRef = (ArrayList<DocumentReference>) document.get("threat_category");
        DocumentReference typeRef = (DocumentReference) document.get("type");

        BiomesRepository biomesRepository = new BiomesRepository();
        GroupiesRepository groupiesRepository = new GroupiesRepository();
        StatesRepository statesRepository = new StatesRepository();
        ProtectionLevelsRepository protectionLevelsRepository = new ProtectionLevelsRepository();
        ThreatCategoriesRepository threatCategoriesRepository = new ThreatCategoriesRepository();
        TypesRepository typesRepository = new TypesRepository();

        ArrayList<Biome> biomes = new ArrayList<Biome>();
        ArrayList<State> occurrenceStates = new ArrayList<State>();
        ArrayList<ProtectionLevel> protectionLevels = new ArrayList<ProtectionLevel>();
        ArrayList<ThreatCategory> threatCategories = new ArrayList<ThreatCategory>();

        biomesRef.forEach(ref -> biomes.add(biomesRepository.findByRef(ref)));
        Group group = groupiesRepository.findByRef(groupRef);
        occurrenceStatesRef.forEach(ref -> occurrenceStates.add(statesRepository.findByRef(ref)));
        protectionLevelsRef.forEach(ref -> protectionLevels.add(protectionLevelsRepository.findByRef(ref)));
        threatCategoriesRef.forEach(ref -> threatCategories.add(threatCategoriesRepository.findByRef(ref)));
        Type type = typesRepository.findByRef(typeRef);

        Boolean countryExclusive = document.getBoolean("country_exclusive");
        String family = document.getString("family");
        Boolean fishingRegulation = document.getBoolean("fishing_regulation");
        ArrayList<String> mainThreats = (ArrayList<String>) document.get("main_threats");
        String name = document.getString("name");
        Boolean pan = document.getBoolean("pan");
        Boolean protectedAreaPresence = document.getBoolean("protected_area_presence");
        String species = document.getString("species");
        String id = document.getId();


        return new EndangeredSpecie(
                id,
                biomes,
                countryExclusive,
                family,
                fishingRegulation,
                group,
                mainThreats,
                name,
                pan,
                protectedAreaPresence,
                protectionLevels,
                species,
                threatCategories,
                type,
                occurrenceStates
        );
    }
}
