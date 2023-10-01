package database_project_API_prototype.databaseAPI.databaseModel;

import org.springframework.lang.NonNull;

public record Address(Integer addressId,
                      String region,
                      String city,
                      String nameOfStreet,
                      int number) {
}
