package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class TransportData implements DatabaseModels {
    private int id;
    private int packageId;
    private int flightId;
    private String cargo;
}
