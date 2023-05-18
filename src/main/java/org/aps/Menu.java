package org.aps;

import org.aps.repositories.EndangeredSpeciesRepository;
import org.aps.services.Firebase;

import java.util.concurrent.ExecutionException;

public class Menu {
    public void execute() {
        EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

//            System.out.println(endangeredSpeciesRepository.findAllByType("LpS9nflQ9RBXPDcUhuMQ").get(0).getGroup().getName());
    }
}
