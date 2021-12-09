package controller;

import database.SQLiteJDBCDriverConnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    public static void createDatabase() {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS package( id INTEGER AUTO_INCREMENT, packageType VARCHAR, packageSubType VARCHAR, owner VARCHAR, heigth INTEGER, heightType VARCHAR, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS packageHistory( id INTEGER AUTO_INCREMENT, author VARCHAR, packageId INTEGER, action VARCHAR, description VARCHAR, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS user( id INTEGER AUTO_INCREMENT, username VARCHAR, password INTEGER, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS transportData( id INTEGER AUTO_INCREMENT, packageId INTEGER, flightId INTEGER, cargo VARCHAR(1), createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS flight( id INTEGER AUTO_INCREMENT, packageId INTEGER, flightId INTEGER, cargo VARCHAR(1), updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS plane( id INTEGER AUTO_INCREMENT, callsign VARCHAR(7), company VARCHAR, model VARCHAR, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS airport( id INTEGER AUTO_INCREMENT, name VARCHAR, code VARCHAR, createdAt DATETIME)");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUser(String username, String password) {
        User user = User.builder().build();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
