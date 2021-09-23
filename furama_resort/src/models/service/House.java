package models.service;

import java.util.Objects;

public class House extends Facility {

    private int rentHours;
    private String roomStander;
    private int numberFloor;

    public House() {
    }

    public House(String serviceName, Double useArea, Double rentCost, int maxPeople, int rentYear, int rentMonth, int rentDay, int rentHours, String roomStander, int numberFloor) {
        super(serviceName, useArea, rentCost, maxPeople, rentYear, rentMonth, rentDay);
        this.rentHours = rentHours;
        this.roomStander = roomStander;
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
        House house = (House) o;
        return rentHours == house.rentHours &&
                numberFloor == house.numberFloor &&
                Objects.equals(roomStander, house.roomStander);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentHours, roomStander, numberFloor);
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", rentHours=" + rentHours +
                ", roomStander='" + roomStander + '\'' +
                ", numberFloor=" + numberFloor ;
    }
}
