package database;

import exception.DatabaseConnectionException;
import exception.DatabaseDisconnectException;

import java.sql.*;

public class SQLiteJDBCDriverConnection {
    private static Connection connection;
    public static Connection connect() throws DatabaseConnectionException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
            return connection;
        } catch (SQLException e) {
           throw new DatabaseConnectionException("Falha ao conectar banco de dados > " + e.getMessage());
        }
    }

    public static boolean disconnect() throws DatabaseDisconnectException {
        try {
            connection.close();
            connection = null;
            return true;
        } catch (SQLException e) {
            throw new DatabaseDisconnectException("Falha ao desconectar banco de dados > " + e.getMessage());
        }
    }
}
