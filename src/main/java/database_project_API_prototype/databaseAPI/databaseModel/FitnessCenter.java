package database_project_API_prototype.databaseAPI.databaseModel;

import java.util.Optional;

public record FitnessCenter(Integer fitnessCenterID,
                            String name,
                            Optional<Address> address) {
}
