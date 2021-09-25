package models.service.villa;

import models.service.facility.Facility;

public class Villa extends Facility {

    private String roomStandard ;
    private double poolArea;
    private int numOfFloor;

    public static final String STANDARD = "standart";
    public static final String DELUXE = "Deluxe";
    public static final String FAMILY = "FAMILY";

    public Villa() {
    }

    public Villa(String serviceName, int usableArea, int rentalCost, int maxNumberOfTenants, String typeOfRent, String roomStandard, double poolArea, int numOfFloor) {
        super(serviceName, usableArea, rentalCost, maxNumberOfTenants, typeOfRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numOfFloor = numOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
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
