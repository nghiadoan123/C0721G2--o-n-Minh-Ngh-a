package models.service.house;

import models.service.facility.Facility;

public class House extends Facility {

    private String roomStander;
    private int numberFloor;

    public House() {
    }

    public House(String serviceName, int usableArea, int rentalCost, int maxNumberOfTenants, String typeOfRent, String roomStander, int numberFloor) {
        super(serviceName, usableArea, rentalCost, maxNumberOfTenants, typeOfRent);
        this.roomStander = roomStander;
        this.numberFloor = numberFloor;
    }

    public String getRoomStander() {
        return roomStander;
    }

    public void setRoomStander(String roomStander) {
        this.roomStander = roomStander;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStander='" + roomStander + '\'' +
                ", numberFloor=" + numberFloor +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getServiceName()+","+super.getUsableArea()+","+super.getRentalCost()+","+super.getMaxNumberOfTenants()+","+super.getTypeOfRent()+","+roomStander+","+numberFloor;
    }
}
