import controller.DatabaseController;
import exception.DatabaseConnectionException;
import exception.DatabaseDisconnectException;
import exception.DatabaseSetupException;
import model.Airport;
import view.*;

import java.sql.SQLException;

public class AirportDispatcher {
    public static void main(String[] args) throws DatabaseSetupException, DatabaseConnectionException, SQLException {
        DatabaseController.createDatabase();
        Login.main(args);
    }
}
