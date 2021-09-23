package models.service;

import java.util.Objects;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, Double useArea, Double rentCost, int maxPeople, int rentYear, int rentMonth, int rentDay, String freeService) {
        super(serviceName, useArea, rentCost, maxPeople, rentYear, rentMonth, rentDay);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(freeService, room.freeService);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", freeService='" + freeService + '\'' ;
    }
}
