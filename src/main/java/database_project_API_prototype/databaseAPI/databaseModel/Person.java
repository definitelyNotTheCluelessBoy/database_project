package database_project_API_prototype.databaseAPI.databaseModel;

import java.util.Optional;

public record Person(String birthNumber,
                     String firstName,
                     String lastName,
                     Optional<Address> address) {
}
