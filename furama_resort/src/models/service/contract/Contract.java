package models.service.contract;

import models.person.Customer;

import java.io.Serializable;

public class Contract implements Comparable<Contract> {
    private int contractNumber;
    private int bookingNumber;
    private double deposit;
    private double totalPayment;
    private Customer customer;

    public Contract() {
    }

    public Contract(int contractNumber, int bookingNumber, double deposit, double totalPayment, Customer customer) {
        this.contractNumber = contractNumber;
        this.bookingNumber = bookingNumber;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customer = customer;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingNumber=" + bookingNumber +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customer=" + customer +
                '}';
    }

    @Override
    public int compareTo(Contract o) {
        return (int) (this.bookingNumber-o.bookingNumber);
    }

    public String getInfoContractToCSV(){
        return contractNumber+","+bookingNumber+","+deposit+","+totalPayment+","+customer.getIdentityNumber();
    }
}
