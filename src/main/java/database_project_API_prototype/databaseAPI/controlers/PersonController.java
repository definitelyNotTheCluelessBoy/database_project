package database_project_API_prototype.databaseAPI.controlers;

import database_project_API_prototype.databaseAPI.databaseModel.Person;
import database_project_API_prototype.databaseAPI.repositories.PersonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{bn}")
    public Person getPersonByBN (@PathVariable String bn) {
        return personRepo.getPersonWithBN(bn).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404"));
    }

    @PostMapping("")
    public void addNewReport(@RequestBody Person person) {
        personRepo.add(person);
    }

    @DeleteMapping("/{birthNumber}")
    public void removeReport(@PathVariable String birthNumber) {
        personRepo.remove(birthNumber);
    }
}
