package database_project_API_prototype.databaseAPI.repositories;

import database_project_API_prototype.databaseAPI.databaseModel.FitnessCenter;
import database_project_API_prototype.databaseAPI.databaseModel.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepo {
    private final List<Person> listOfAllPersons = new ArrayList<>();
    private final AddressRepo addressRepo;

    public PersonRepo(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Optional<Person> getPersonWithBN(String birthNumber) {
        return listOfAllPersons.stream().filter(content -> content.birthNumber().equals(birthNumber)).findAny();
    }

    public void add(Person person) {
        listOfAllPersons.add(person);
    }

    public void remove(String birthNumber) {
        listOfAllPersons.removeIf(content -> content.birthNumber().equals(birthNumber));
    }

    @PostConstruct
    private void dataCreation() {
        Person newPersonOne = new Person("145422544545","janko","mrkvicka", addressRepo.getAddressWithID(4));
        Person newPersonTwo = new Person("476868675645","ferko" , "dlhy", addressRepo.getAddressWithID(4));
        listOfAllPersons.add(newPersonOne);
        listOfAllPersons.add(newPersonTwo);
    }
}
