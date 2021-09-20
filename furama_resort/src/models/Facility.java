package models;

import java.util.Objects;

public abstract class Facility {
    private String serviceName;
    private Double useArea;
    private Double rentCost;
    private int maxPeople;
    private int rentYear;
    private int rentMonth;
    private int rentDay;

    public Facility() {
    }

    public Facility(String serviceName, Double useArea, Double rentCost, int maxPeople, int rentYear, int rentMonth, int rentDay) {
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentCost = rentCost;
        this.maxPeople = maxPeople;
        this.rentYear = rentYear;
        this.rentMonth = rentMonth;
        this.rentDay = rentDay;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUseArea() {
        return useArea;
    }

    public void setUseArea(Double useArea) {
        this.useArea = useArea;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentYear() {
        return rentYear;
    }

    public void setRentYear(int rentYear) {
        this.rentYear = rentYear;
    }

    public int getRentMonth() {
        return rentMonth;
    }

    public void setRentMonth(int rentMonth) {
        this.rentMonth = rentMonth;
    }

    public int getRentDay() {
        return rentDay;
    }

    public void setRentDay(int rentDay) {
        this.rentDay = rentDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return maxPeople == facility.maxPeople &&
                rentYear == facility.rentYear &&
                rentMonth == facility.rentMonth &&
                rentDay == facility.rentDay &&
                Objects.equals(serviceName, facility.serviceName) &&
                Objects.equals(useArea, facility.useArea) &&
                Objects.equals(rentCost, facility.rentCost);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "serviceName='" + serviceName + '\'' +
                ", useArea=" + useArea +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", rentYear=" + rentYear +
                ", rentMonth=" + rentMonth +
                ", rentDay=" + rentDay ;
    }
}
