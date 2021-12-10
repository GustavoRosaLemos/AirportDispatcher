package database;

import exception.DatabaseConnectionException;
import exception.DatabaseDisconnectException;

import java.sql.*;

public class SQLiteJDBCDriverConnection {
    public static Connection connect() throws DatabaseConnectionException {
        try {
            return DriverManager.getConnection("jdbc:sqlite:banco.db");
        } catch (SQLException e) {
           throw new DatabaseConnectionException("Falha ao conectar banco de dados > " + e.getMessage());
        }
    }
}
