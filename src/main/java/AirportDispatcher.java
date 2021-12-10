import controller.DatabaseController;
import database.SQLiteJDBCDriverConnection;
import view.*;

public class AirportDispatcher {
    public static void main(String[] args) {
        DatabaseController.createDatabase();
//        InformacaoPacote.main(args);
        Login.main(args);
    }
}
