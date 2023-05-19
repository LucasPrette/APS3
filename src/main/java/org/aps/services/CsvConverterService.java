package org.aps.services;


import org.aps.implementations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class CsvConverterService {

    String file = "APS3/src/main/java/org/aps/configs/lista-de-especies-ameacas-2020.csv";
    String line = "";

    public ArrayList<EndangeredSpecie> csvToJClass() {
        ArrayList<EndangeredSpecie> result = new ArrayList<EndangeredSpecie>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));

            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }

                String[] attributes = line.replace("; ", ",").split(";");

                Type type = new Type(this.sanitize(attributes[0]).toLowerCase());
                Group group = new Group(this.sanitize(attributes[1]));
                String family = this.sanitize(attributes[2]);
                String species = attributes[3];
                String name = this.sanitize(attributes[4]);
                String threatCategoryName = this.sanitize(attributes[5]);
                String threatCategoryAcronym = this.sanitize(attributes[6]);

                ArrayList<Biome> biomes = new ArrayList<Biome>();

                for (String attr : attributes[7].split(",")) {
                    new Biome(this.sanitize(attr));
                }

                ArrayList<String> mainThreats = new ArrayList<String>();

                for (String attr : attributes[8].split(",")) {
                    mainThreats.add(this.sanitize(attr));
                }

                boolean protectedAreaPresence = this.convertStrToBool(attributes[9]);
                boolean pan = this.convertStrToBool(attributes[10]);
                boolean fishingRegulation = this.convertStrToBool(attributes[11]);
                ProtectionLevel protectionLevel = new ProtectionLevel(Integer.parseInt(this.sanitize(attributes[12])));
                boolean countryExclusive =  this.convertStrToBool(attributes[13]);

                ArrayList<State> occurrenceStates = new ArrayList<State>();

                for (String attr : attributes[14].split(",")) {
                    State state = new State(this.sanitize(attr));

                    occurrenceStates.add(state);
                }

                ThreatCategory threatCategory = new ThreatCategory(threatCategoryName, threatCategoryAcronym);
                EndangeredSpecie endangeredSpecie = new EndangeredSpecie(
                        biomes,
                        countryExclusive,
                        family,
                        fishingRegulation,
                        group,
                        mainThreats,
                        name,
                        pan,
                        protectedAreaPresence,
                        protectionLevel,
                        species,
                        threatCategory,
                        type,
                        occurrenceStates
                );

                result.add(endangeredSpecie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return result;
    }

    private boolean convertStrToBool(String str) {
        return str.trim().toLowerCase().equals("sim");
    }

    private String sanitize(String str) {
        return str.trim();
    }
}
