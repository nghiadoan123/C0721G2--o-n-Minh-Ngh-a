package models.service;

import java.util.Objects;

public class Villa extends Facility {

    private String roomStandard ;
    private double poolArea;
    private int numOfFloor;

    public Villa() {
    }

    public Villa(String serviceName, int usableArea, int rentalCost, int maxNumberOfTenants, String typeOfRent, String roomStandard, double poolArea, int numOfFloor) {
        super(serviceName, usableArea, rentalCost, maxNumberOfTenants, typeOfRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numOfFloor=" + numOfFloor +
                '}';
    }
}
