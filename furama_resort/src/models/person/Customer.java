package models.person;

import models.service.Facility;

public class Customer extends Person {
    private Facility facility;
    private String typeOfCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dayOfBirth, String gender, int identityNumber, String phoneNumber, String email, String typeOfCustomer, String address) {
        super(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'';
    }
}
