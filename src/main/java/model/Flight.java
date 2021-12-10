package model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class Flight {
    private int id;
    private String planeCallsign;
    private String source;
    private String departure;
    private String departureDate;
    private String arrival;
    private String arrivalDate;

    public int getId() {
        return id;
    }

    public String getPlaneCallsign() {
        return planeCallsign;
    }

    public String getSource() {
        return source;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrival() {
        return arrival;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
