package utils;


public abstract class PackageTools {
    public static String getPackageTypeInitials(String packageType) {
        return packageType.substring(0, 2).toUpperCase();
    }

    public static String getPackageCategoryInitials(String packageCategory) {
        return packageCategory.substring(0, 2).toUpperCase();
    }
}
