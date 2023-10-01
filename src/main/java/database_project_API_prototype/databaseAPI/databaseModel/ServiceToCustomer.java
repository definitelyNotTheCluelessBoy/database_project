package database_project_API_prototype.databaseAPI.databaseModel;

import java.util.Date;

public record ServiceToCustomer(
        Service service,
        Customer customer,
        Date date
) {
}
