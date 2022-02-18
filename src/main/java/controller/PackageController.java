package controller;

import exception.DatabaseConnectionException;
import exception.DatabaseSetupException;
import model.Package;
import session.UserSession;

import java.util.List;

public abstract class PackageController {
    public static boolean addPackage(String packageType, String packageCategory, String owner, int weight, String weightType, String planeCallsign, String cargo) {
        int packageId = DatabaseController.addPackage(packageType, packageCategory, owner, weight, weightType);
        System.out.println("packageId " + packageId);
        if (packageId == -1) { return false; }
        int flightId = DatabaseController.getFlights(planeCallsign).get(0).getId();
        if(flightId == -1) { return false; }
        DatabaseController.addTransportData(packageId, flightId, cargo);
        PackageHistoryController.addHistory(packageId, "Pacote Registrado", UserSession.getUsername());
        return true;
    }

    public static Package getPackageById(int id) {
        return DatabaseController.getPackage(id);
    }

    public static List<Package> getAllPackages() { return DatabaseController.getPackages(); };
}
