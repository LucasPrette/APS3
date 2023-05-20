package org.aps.implementations;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.aps.repositories.*;

import java.util.ArrayList;

public class EndangeredSpecies {
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
    private ProtectionLevel protectionLevel;
    private String species;
    private ThreatCategory threatCategory;
    private Type type;
    private ArrayList<State> occurrenceStates;

    public EndangeredSpecies(
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
            ProtectionLevel protectionLevel,
            String species,
            ThreatCategory threatCategory,
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
        this.protectionLevel = protectionLevel;
        this.protectedAreaPresence = protectedAreaPresence;
        this.species = species;
        this.threatCategory = threatCategory;
        this.type = type;
        this.occurrenceStates = occurrenceStates;
    }

    public EndangeredSpecies(
            ArrayList<Biome> biomes,
            Boolean countryExclusive,
            String family,
            boolean fishingRegulation,
            Group group,
            ArrayList<String> mainThreats,
            String name,
            boolean pan,
            boolean protectedAreaPresence,
            ProtectionLevel protectionLevel,
            String species,
            ThreatCategory threatCategory,
            Type type,
            ArrayList<State> occurrenceStates
    ) {
        this.biomes = biomes;
        this.countryExclusive = countryExclusive;
        this.family = family;
        this.fishingRegulation = fishingRegulation;
        this.group = group;
        this.mainThreats = mainThreats;
        this.name = name;
        this.pan = pan;
        this.protectionLevel = protectionLevel;
        this.protectedAreaPresence = protectedAreaPresence;
        this.species = species;
        this.threatCategory = threatCategory;
        this.type = type;
        this.occurrenceStates = occurrenceStates;
    }

    public EndangeredSpecies() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Biome> getBiomes() {
        return biomes;
    }

    public ProtectionLevel getProtectionLevel() {
        return protectionLevel;
    }

    public String getSpecies() {
        return species;
    }

    public ArrayList<String> getMainThreats() {
        return mainThreats;
    }

    public ThreatCategory getThreatCategory() {
        return threatCategory;
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

    public ArrayList<State> getOccurrenceStates() {
        return occurrenceStates;
    }

    public boolean getFishingRegulation() { return fishingRegulation; }

    public boolean getPan() { return pan; }

    public boolean getProtectedAreaPresence() { return protectedAreaPresence; }
}
