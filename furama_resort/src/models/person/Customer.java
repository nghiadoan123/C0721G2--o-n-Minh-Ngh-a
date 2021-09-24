package models.person;

import models.service.Facility;

public class Customer extends Person {
    private String typeOfCustomer;
    private String address;

    public final static String DIAMOND = "Diamond";
    public final static String PLATINUM = "Platinum";
    public final static String GOLD = "Gold";
    public final static String SILVER = "Silver";
    public final static String MEMBER = "Member";


    public Customer() {
    }

    public Customer(String id, String name, String dayOfBirth, String gender, int identityNumber, String phoneNumber, String email, String typeOfCustomer, String address) {
        super(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
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
        return "Customer{" +
                super.toString() +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
