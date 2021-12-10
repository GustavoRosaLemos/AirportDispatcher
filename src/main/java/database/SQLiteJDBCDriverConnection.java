package database;

import java.sql.*;

public class SQLiteJDBCDriverConnection {
    private static Connection connection;
    public static Connection connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean disconnect() {
        try {
            connection.close();
            connection = null;
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
