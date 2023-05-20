package org.aps;

import org.aps.implementations.EndangeredSpecies;
import org.aps.repositories.EndangeredSpeciesRepository;
import org.aps.services.CsvConverterService;

import java.util.ArrayList;

public class Main {
    private void populate() {
        CsvConverterService csvConverterService = new CsvConverterService();

        ArrayList<EndangeredSpecies> endangeredSpecies = csvConverterService.csvToJClass();

        System.out.println(endangeredSpecies.size());
    }

    public static void main(String[] args) {
        new Main().populate();
//        EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();
//
//        endangeredSpeciesRepository.populate(new ArrayList<EndangeredSpecies>());
//            System.out.println(endangeredSpeciesRepository.findAll().get(0).getBiomes().get(0).getId());
    }
}