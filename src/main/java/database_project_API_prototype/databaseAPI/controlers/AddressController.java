package database_project_API_prototype.databaseAPI.controlers;


import database_project_API_prototype.databaseAPI.databaseModel.Address;
import database_project_API_prototype.databaseAPI.repositories.AddressRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressRepo addressRepo;

    public AddressController(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @GetMapping("/{id}")
    public Address getAddressByID (@PathVariable Integer id) {
        return addressRepo.getAddressWithID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404"));
    }

    @PostMapping("")
    public void addNewReport(@RequestBody Address address) {
        addressRepo.add(address);
    }

    @DeleteMapping("/{id}")
    public void removeReport(@PathVariable Integer id) {
        addressRepo.remove(id);
    }
}
