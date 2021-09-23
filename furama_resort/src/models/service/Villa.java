package models.service;

import java.util.Objects;

public class Villa extends Facility {

    private int rentHours;
    private String roomStander;
    private Double poolArea;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String serviceName, Double useArea, Double rentCost, int maxPeople, int rentYear, int rentMonth, int rentDay, int rentHours, String roomStander, Double poolArea, int numberFloor) {
        super(serviceName, useArea, rentCost, maxPeople, rentYear, rentMonth, rentDay);
        this.rentHours = rentHours;
        this.roomStander = roomStander;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public int getRentHours() {
        return rentHours;
    }

    public void setRentHours(int rentHours) {
        this.rentHours = rentHours;
    }

    public String getRoomStander() {
        return roomStander;
    }

    public void setRoomStander(String roomStander) {
        this.roomStander = roomStander;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return rentHours == villa.rentHours &&
                numberFloor == villa.numberFloor &&
                Objects.equals(roomStander, villa.roomStander) &&
                Objects.equals(poolArea, villa.poolArea);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", rentHours=" + rentHours +
                ", roomStander='" + roomStander + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor;
    }
}
