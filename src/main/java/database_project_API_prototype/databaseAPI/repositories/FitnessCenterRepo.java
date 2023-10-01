package database_project_API_prototype.databaseAPI.repositories;

import database_project_API_prototype.databaseAPI.databaseModel.Address;
import database_project_API_prototype.databaseAPI.databaseModel.FitnessCenter;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FitnessCenterRepo {
    private final List<FitnessCenter> listOfFitnessCenters = new ArrayList<FitnessCenter>();
    private final AddressRepo addressRepo;

    public FitnessCenterRepo(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Optional<FitnessCenter> getFitnessCenterWithID(Integer ID) {
        return listOfFitnessCenters.stream().filter(content -> content.fitnessCenterID().equals(ID)).findAny();
    }

    public void add(FitnessCenter fitnessCenter) {
        listOfFitnessCenters.add(fitnessCenter);
    }

    public void remove(Integer id) {
        listOfFitnessCenters.removeIf(content -> content.fitnessCenterID().equals(id));
    }

        @PostConstruct
    private void dataCreation() {
            FitnessCenter newFitnessCenterOne = new FitnessCenter(1,"First", addressRepo.getAddressWithID(1));
            FitnessCenter newFitnessCenterTwo = new FitnessCenter(2,"First", addressRepo.getAddressWithID(2));
            listOfFitnessCenters.add(newFitnessCenterTwo);
            listOfFitnessCenters.add(newFitnessCenterOne);
        }
}
