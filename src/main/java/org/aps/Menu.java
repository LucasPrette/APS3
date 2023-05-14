package org.aps;

import org.aps.repositories.EndangeredSpeciesRepository;

public class Menu {
    public void execute() {
        EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

        System.out.println(endangeredSpeciesRepository.find().get(0).getGroup().getName());
    }
}
