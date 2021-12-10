package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class Flight implements DatabaseModels {
    private int id;
    private String planeCallsign;
    private String source;
    private String departure;
    private String departureDate;
    private String arrival;
    private String arrivalDate;
}
