package org.aps;

import org.aps.implementations.EndangeredSpecies;
import org.aps.repositories.EndangeredSpeciesRepository;
import org.aps.services.CsvConverterService;
import org.aps.views.Gui;

import java.util.List;

public class Main {
    private void populate() {
        CsvConverterService csvConverterService = new CsvConverterService();
        EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

        List<EndangeredSpecies> endangeredSpecies = csvConverterService.csvToJClass();

        /**
         * 0-100 => ok
         * 100-500 => ok
         * 500-1200 => ok
         * 1200-1958 => ok
         */
        endangeredSpeciesRepository.populate(endangeredSpecies.subList(0, 100));
    }

//    public static void main(String[] args) {
//        new Main().populate();
//    }

    public static void main(String[] args) {
        new Gui().runGUI();
    }
}