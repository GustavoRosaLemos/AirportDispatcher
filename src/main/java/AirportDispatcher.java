import controller.DatabaseController;
import exception.DatabaseConnectionException;
import exception.DatabaseDisconnectException;
import exception.DatabaseSetupException;
import model.Airport;
import model.Package;
import model.User;
import view.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class AirportDispatcher {
    public static void main(String[] args) throws DatabaseSetupException, DatabaseConnectionException, SQLException {
        Login.main(args);
    }
}
