import controller.DatabaseController;
import database.SQLiteJDBCDriverConnection;
import view.Login;

public class AirportDispatcher {
    public static void main(String[] args) {
        DatabaseController.createDatabase();
        Login.main(args);
    }
}
