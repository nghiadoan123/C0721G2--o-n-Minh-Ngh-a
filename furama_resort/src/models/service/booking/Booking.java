package models.service.booking;

import models.person.Customer;
import models.service.facility.Facility;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Comparable<Booking>,Serializable {
    private String bookingId;
    private Date checkIn;
    private Date checkOut;
    private Customer customer;
    private Facility facility;


    public Booking() {
    }

    public Booking(String bookingId, Date checkIn, Date checkOut, Customer customer, Facility facility) {
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.customer = customer;
        this.facility = facility;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }


    @Override
    public int compareTo(Booking o) {
        try {
            if (this.bookingId.compareTo(o.bookingId) == 0) {
                if (this.checkIn.compareTo(o.checkIn) == 0) {
                    if (this.checkOut.compareTo(o.checkOut) == 0) {
                        if (this.getCustomer().getId() == o.getCustomer().getId()) {
                            return this.getFacility().getServiceName().compareTo(o.getFacility().getServiceName());
                        } else {
                            return this.getCustomer().getId().compareTo(o.getCustomer().getId());
                        }
                    } else {
                        return this.checkOut.compareTo(o.checkOut);
                    }
                } else {
                    return this.checkIn.compareTo(o.checkIn);
                }
            } else {
                return this.bookingId.compareTo(o.bookingId);
            }
        } catch (NullPointerException e) {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", customer=" + customer +
                ", facility=" + facility +
                '}';
    }

    public String getInfoBookingToCSV(){
        return bookingId+","+checkIn+","+checkOut+","+customer.getId()+","+facility.getServiceName();
    }
}
