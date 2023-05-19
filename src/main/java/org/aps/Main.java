package org.aps;

import org.aps.implementations.EndangeredSpecie;
import org.aps.repositories.EndangeredSpeciesRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

        endangeredSpeciesRepository.populate(new ArrayList<EndangeredSpecie>());
//            System.out.println(endangeredSpeciesRepository.findAll().get(0).getBiomes().get(0).getId());
    }
}