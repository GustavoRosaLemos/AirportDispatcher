package controller;

import model.Plane;

public class PlaneController {
    public static Plane getPlaneByCallSign(String callSign) {
        return DatabaseController.getPlane(callSign);
    }
}
