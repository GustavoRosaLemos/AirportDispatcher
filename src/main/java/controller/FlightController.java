package controller;

import model.Flight;

public abstract class FlightController {
    public static Flight getFlightById(int flightId) {
        return DatabaseController.getFlight(flightId);
    }
}
