package controller;

import model.PackageHistory;

import java.util.List;

public class PackageHistoryController {
    public static void addHistory(int packageId, String action, String author) {
        DatabaseController.addPackageHistory(packageId, action, author);
    }
    public static List<PackageHistory> getPackageHistoriesByPackageId(int packageId) {
        return DatabaseController.getPackageHistories(packageId);
    }
    public static List<PackageHistory> getAllPackageHistories() {
        return DatabaseController.getPackageHistories();
    }
}
