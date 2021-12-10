import controller.DatabaseController;
import exception.DatabaseConnectionException;
import exception.DatabaseSetupException;
import view.*;

import java.sql.SQLException;

public class AirportDispatcher {
    public static void main(String[] args) throws DatabaseSetupException, DatabaseConnectionException, SQLException {
        DatabaseController.createDatabase();
//        InformacaoPacote.main(args);
        Login.main(args);
    }
}
