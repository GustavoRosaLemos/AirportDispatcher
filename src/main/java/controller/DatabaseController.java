package controller;

import database.SQLiteJDBCDriverConnection;
import exception.DatabaseConnectionException;
import exception.DatabaseSetupException;
import model.*;
import model.Package;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseController {
    public static void createDatabase() throws DatabaseSetupException, SQLException, DatabaseConnectionException {
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
            throw new DatabaseSetupException("Falha ao realizar setup do banco de dados > " + e.getMessage());
        }
    }

    public static String addPackage(String packageType, String packageCategory, String owner, int weight, String weightType) {
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
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return "-1";
    }

    public static String addTransportData(int packageId, int flightId, String cargo)  {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO transportData(packageId, flightId, cargo, createdAt) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, packageId);
            stmt.setInt(2, flightId);
            stmt.setString(3, cargo);
            stmt.setString(4, LocalDateTime.now().toString());
            stmt.execute();
            return stmt.getGeneratedKeys().getString(1);
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return "-1";
    }

    public static TransportData getTransportData(int packageId) {
        TransportData transportData = TransportData.builder().build();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM transportData WHERE packageId = ?");
            stmt.setInt(1, packageId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                transportData.setId(resultSet.getInt("id"));
                transportData.setPackageId(resultSet.getInt("packageId"));
                transportData.setFlightId(resultSet.getInt("flightId"));
                transportData.setCargo(resultSet.getString("cargo"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return transportData;
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
        } catch (SQLException | DatabaseConnectionException e) {
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
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return airports;
    }

    public static Plane getPlane(String callsign) {
        Plane plane = Plane.builder().build();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM plane WHERE callsign = ?");
            stmt.setString(1, callsign);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                plane.setId(resultSet.getInt("id"));
                plane.setCallsign(resultSet.getString("callsign"));
                plane.setCompany(resultSet.getString("company"));
                plane.setCargoQuantity(resultSet.getInt("cargoQuantity"));
                plane.setModel(resultSet.getString("model"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return plane;
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
        } catch (SQLException | DatabaseConnectionException e) {
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
        } catch (SQLException | DatabaseConnectionException e) {
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
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }

    public static Flight getFlight(int id) {
        Flight flight = Flight.builder().build();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM flight WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                flight.setId(resultSet.getInt("id"));
                flight.setArrival(resultSet.getString("arrival"));
                flight.setDeparture(resultSet.getString("departure"));
                flight.setSource(resultSet.getString("source"));
                flight.setPlaneCallsign(resultSet.getString("planeCallsign"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return flight;
    }

    public static Package getPackage(int id) {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM package WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Package aPackage;
                if (resultSet.getString("packageCategory").toString().equalsIgnoreCase("Refrigerado")) {
                    aPackage = PackageRefrigerated.builder().build();
                } else if (resultSet.getString("packageCategory").toString().equalsIgnoreCase("Vivo")) {
                    aPackage = PackageLive.builder().build();
                } else {
                    aPackage = Package.builder().build();
                }
                aPackage.setId(resultSet.getInt("id"));
                aPackage.setPackageType(resultSet.getString("packageType"));
                aPackage.setPackageCategory(resultSet.getString("packageCategory"));
                aPackage.setOwner(resultSet.getString("owner"));
                aPackage.setWeight(resultSet.getInt("weight"));
                aPackage.setWeightType(resultSet.getString("weightType"));
                return aPackage;
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<Package> getPackages() {
        ArrayList<Package> packages = new ArrayList<Package>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM package");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                packages.add(
                        Package.builder()
                                .id(resultSet.getInt("id"))
                                .owner(resultSet.getString("owner"))
                                .packageCategory(resultSet.getString("packageCategory"))
                                .packageType(resultSet.getString("packageType"))
                                .weight(resultSet.getInt("weight"))
                                .weightType(resultSet.getString("weightType"))
                                .build()
                );
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return packages;
    }

    public static void addPackageHistory(int packageId, String action, String author) {
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO packageHistory(packageId, action, author, createdAt) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, packageId);
            stmt.setString(2, action);
            stmt.setString(3, author);
            stmt.setString(4, LocalDateTime.now().toString());
            stmt.execute();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<PackageHistory> getPackageHistories() {
        ArrayList<PackageHistory> packageHistories = new ArrayList<PackageHistory>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM packageHistory");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                packageHistories.add(
                        PackageHistory.builder()
                                .id(resultSet.getInt("id"))
                                .action(resultSet.getString("action"))
                                .packageId(resultSet.getInt("packageId"))
                                .createdAt(resultSet.getString("createdAt"))
                                .author(resultSet.getString("author"))
                                .build()
                );
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return packageHistories;
    }

    public static List<PackageHistory> getPackageHistories(int packageId) {
        ArrayList<PackageHistory> packageHistories = new ArrayList<PackageHistory>();
        try {
            Connection connection = SQLiteJDBCDriverConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM packageHistory WHERE packageId = ?");
            stmt.setInt(1, packageId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                packageHistories.add(
                        PackageHistory.builder()
                                .id(resultSet.getInt("id"))
                                .action(resultSet.getString("action"))
                                .packageId(resultSet.getInt("packageId"))
                                .createdAt(resultSet.getString("createdAt"))
                                .author(resultSet.getString("author"))
                                .build()
                );
            }
            stmt.close();
            connection.close();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
        return packageHistories;
    }
}
