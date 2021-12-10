package model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Plane {
    private int id;
    private String callsign;
    private String company;
    private String model;
    private int cargoQuantity;

    public int getId() {
        return id;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }
}
