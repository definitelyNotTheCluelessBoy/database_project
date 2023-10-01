package database_project_API_prototype.databaseAPI.repositories;

import database_project_API_prototype.databaseAPI.databaseModel.Address;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class AddressRepo {

    private final ArrayList<Address> listOfAddresses = new ArrayList<Address>();

    public Optional<Address> getAddressWithID(Integer ID) {
        return listOfAddresses.stream().filter(c -> c.addressId().equals(ID)).findAny();
    }

    @PostConstruct
    private void dataCreation() {
        for (int i = 0; i < 10; i++) {
            Address address = new Address(i,"","","",i);
            listOfAddresses.add(address);
        }
    }

    public void add(Address address) {
        listOfAddresses.add(address);
    }

    public void remove(Integer id) {
        listOfAddresses.removeIf(content -> content.addressId().equals(id));
    }
}
