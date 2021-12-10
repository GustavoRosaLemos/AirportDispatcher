package controller;

import model.TransportData;

public abstract class TransportDataController {
    public static TransportData getTransportDataPackageId(int packageId) {
        return DatabaseController.getTransportData(packageId);
    }
}
