package controller;

import database.SQLiteJDBCDriverConnection;
import model.Airport;
import model.Flight;
import model.Plane;
import model.User;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {
    public static void createDatabase() {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            Statement statement = connection.createStatement();

//            statement.execute("INSERT INTO user(username, password) VALUES ('gustavo.lemos', '123456')");
//            statement.execute("INSERT INTO user(username, password) VALUES ('paulo.dalescio', '123456')");

//            statement.execute(String.format("INSERT INTO flight(planeCallsign, source, departure, departureDate, arrival, arrivalDate, updatedAt, createdAt) VALUES ('GUG2233', '%s', 'FLN', '%s', 'GIG', '%s', '%s', '%s')", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO flight(planeCallsign, source, departure, departureDate, arrival, arrivalDate, updatedAt, createdAt) VALUES ('GUG2233', '%s', 'GIG', '%s', 'FLN', '%s', '%s', '%s')", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO flight(planeCallsign, source, departure, departureDate, arrival, arrivalDate, updatedAt, createdAt) VALUES ('TAM1234', '%s', 'GRU', '%s', 'GIG', '%s', '%s', '%s')", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO flight(planeCallsign, source, departure, departureDate, arrival, arrivalDate, updatedAt, createdAt) VALUES ('TAM1234', '%s', 'GRU', '%s', 'FLN', '%s', '%s', '%s')", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));

//            statement.execute(String.format("INSERT INTO airport(name, code, createdAt) VALUES ('Florianópolis', 'FLN', '%s')", LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO airport(name, code, createdAt) VALUES ('Guarulhos', 'GRU', '%s')", LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO airport(name, code, createdAt) VALUES ('Galeão', 'GIG', '%s')", LocalDateTime.now()));

//            statement.execute(String.format("INSERT INTO plane(callSign, company, model, cargoQuantity, updatedAt, createdAt) VALUES ('GUG2233', 'Gol', 'Boing 737 Max', 3, '%s', '%s')", LocalDateTime.now(), LocalDateTime.now()));
//            statement.execute(String.format("INSERT INTO plane(callSign, company, model, cargoQuantity, updatedAt, createdAt) VALUES ('TAM1234', 'Latam', 'Airbus A380', 3, '%s', '%s')", LocalDateTime.now(), LocalDateTime.now()));

//            statement.execute("DROP TABLE package");
//            statement.execute("DROP TABLE packageHistory");
//            statement.execute("DROP TABLE user");
//            statement.execute("DROP TABLE transportData");
//            statement.execute("DROP TABLE flight");
//            statement.execute("DROP TABLE plane");
//            statement.execute("DROP TABLE airport");

            statement.execute("CREATE TABLE IF NOT EXISTS package( id INTEGER PRIMARY KEY AUTOINCREMENT, packageType VARCHAR, packageCategory VARCHAR, owner VARCHAR, weight INTEGER, weightType VARCHAR, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS packageHistory( id INTEGER PRIMARY KEY AUTOINCREMENT, author VARCHAR, packageId INTEGER, action VARCHAR, description VARCHAR, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS user( id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password INTEGER, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS transportData( id INTEGER PRIMARY KEY AUTOINCREMENT, packageId INTEGER, flightId INTEGER, cargo VARCHAR(1), createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS flight( id INTEGER PRIMARY KEY AUTOINCREMENT, planeCallsign INTEGER, source VARCHAR(3), departure VARCHAR(3), departureDate DATETIME, arrival VARCHAR(3), arrivalDate DATETIME, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS plane( id INTEGER PRIMARY KEY AUTOINCREMENT, callsign VARCHAR(7), company VARCHAR, model VARCHAR, cargoQuantity INT, updatedAt DATETIME, createdAt DATETIME)");
            statement.execute("CREATE TABLE IF NOT EXISTS airport( id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, code VARCHAR, createdAt DATETIME)");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String createPackage(String packageType, String packageCategory, String owner, int weight, String weightType) {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO package(packageType, packageCategory, owner, weight, weightType, updatedAt, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, packageType);
            stmt.setString(2, packageCategory);
            stmt.setString(3, owner);
            stmt.setInt(4, weight);
            stmt.setString(5, weightType);
            stmt.setString(6, LocalDateTime.now().toString());
            stmt.setString(7, LocalDateTime.now().toString());
            stmt.execute();
            return stmt.getGeneratedKeys().getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "-1";
    }

    public static String createTransportData(int packageId, int flightId, String cargo) {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO transportData(packageId, flightId, cargo, createdAt) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, packageId);
            stmt.setInt(2, flightId);
            stmt.setString(3, cargo);
            stmt.setString(4, LocalDateTime.now().toString());
            stmt.execute();
            return stmt.getGeneratedKeys().getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "-1";
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
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static List<Airport> getAirports() {
        ArrayList<Airport> airports = new ArrayList<>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM airport");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                airports.add(Airport.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).code(resultSet.getString("code")).build());
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return airports;
    }

    public static List<Plane> getPlanes() {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM plane");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                planes.add(Plane.builder().id(resultSet.getInt("id")).callsign(resultSet.getString("callsign")).company(resultSet.getString("company")).model(resultSet.getString("model")).cargoQuantity(resultSet.getInt("cargoQuantity")).build());
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return planes;
    }

    public static List<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM flight");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                flights.add(Flight.builder().id(resultSet.getInt("id")).planeCallsign(resultSet.getString("planeCallsign")).departure(resultSet.getString("departure")).arrival(resultSet.getString("arrival")).build());
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }

    public static List<Flight> getFlights(String planeCallsign) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM flight WHERE planeCallsign = ?");
            stmt.setString(1, planeCallsign);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                flights.add(Flight.builder().id(resultSet.getInt("id")).planeCallsign(resultSet.getString("planeCallsign")).departure(resultSet.getString("departure")).arrival(resultSet.getString("arrival")).build());
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }
}
