package database_project_API_prototype.databaseAPI.controlers;


import database_project_API_prototype.databaseAPI.databaseModel.Address;
import database_project_API_prototype.databaseAPI.databaseModel.FitnessCenter;
import database_project_API_prototype.databaseAPI.repositories.AddressRepo;
import database_project_API_prototype.databaseAPI.repositories.FitnessCenterRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("api/fitnessCenter")
@RestController
public class FitnessCenterController {
    private final FitnessCenterRepo fitnessCenterRepo;

    public FitnessCenterController(FitnessCenterRepo fitnessCenterRepo) {
        this.fitnessCenterRepo = fitnessCenterRepo;
    }

    @GetMapping("/{id}")
    public FitnessCenter getAddressByID (@PathVariable Integer id) {
        return fitnessCenterRepo.getFitnessCenterWithID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404"));
    }

    @PostMapping("")
    public void addNewReport(@RequestBody FitnessCenter fitnessCenter) {
        fitnessCenterRepo.add(fitnessCenter);
    }

    @DeleteMapping("/{id}")
    public void removeReport(@PathVariable Integer id) {
        fitnessCenterRepo.remove(id);
    }
}
