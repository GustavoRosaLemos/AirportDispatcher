package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PackageLive extends Package {
    private boolean needFoodInTransport = false;
    private boolean needWaterInTransport = false;
    public PackageLive(int id, String packageType, String packageCategory, String owner, int weight, String weightType) {
        super(id, packageType, packageCategory, owner, weight, weightType);
    }

    public PackageLive(int id, String packageType, String packageCategory, String owner, int weight, String weightType, boolean needFoodInTransport, boolean needWaterInTransport) {
        super(id, packageType, packageCategory, owner, weight, weightType);
        this.needFoodInTransport = needFoodInTransport;
        this.needWaterInTransport = needWaterInTransport;
    }
}
