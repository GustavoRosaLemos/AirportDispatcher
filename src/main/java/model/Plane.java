package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Plane implements DatabaseModels {
    private int id;
    private String callsign;
    private String company;
    private String model;
    private int cargoQuantity;
}
