package models;

public class Booking implements Comparable<Booking> {
    private int bookingId;
    private int startDay;
    private int stopDay;
    private int customerId;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(int bookingId, int startDay, int stopDay, int customerId, String serviceName, String serviceType) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.stopDay = stopDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStopDay() {
        return stopDay;
    }

    public void setStopDay(int stopDay) {
        this.stopDay = stopDay;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "bookingId=" + bookingId +
                ", startDay=" + startDay +
                ", stopDay=" + stopDay +
                ", customerId=" + customerId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' ;
    }

    @Override
    public int compareTo(Booking o) {
        if (this.getStartDay() == o.startDay){
           return this.getStopDay()-o.stopDay;
        }else {
            return this.getStartDay()-o.startDay;
        }
    }
}
