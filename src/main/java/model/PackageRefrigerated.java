package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageRefrigerated extends Package {
    private int packageMinTemperature = -20;
    private int packageMaxTemperature = 5;
    public PackageRefrigerated(int id, String packageType, String packageCategory, String owner, int weight, String weightType) {
        super(id, packageType, packageCategory, owner, weight, weightType);
    }
    public PackageRefrigerated(int id, String packageType, String packageCategory, String owner, int weight, String weightType, int packageMinTemperature, int packageMaxTemperature) {
        super(id, packageType, packageCategory, owner, weight, weightType);
        this.packageMinTemperature = packageMinTemperature;
        this.packageMaxTemperature = packageMaxTemperature;
    }
}
