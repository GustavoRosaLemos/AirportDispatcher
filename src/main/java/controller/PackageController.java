package controller;

public abstract class PackageController {
    public static boolean addPackage(String packageType, String packageCategory, String owner, int weight, String weightType, String planeCallsign, String cargo) {
        int packageId = Integer.parseInt(DatabaseController.createPackage(packageType, packageCategory, owner, weight, weightType));
        if (packageId == -1) { return false; }
        int flightId = DatabaseController.getFlights(planeCallsign).get(0).getId();
        if(flightId == -1) { return false; }
        DatabaseController.createTransportData(packageId, flightId, cargo);
        return true;
    }
}
