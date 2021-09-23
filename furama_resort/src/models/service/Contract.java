package models.service;

public class Contract implements Comparable<Contract> {
    private int contractNumber;
    private int bookingNumber;
    private double deposit;
    private double totalPayment;
    private int customerId;

    public Contract() {
    }

    public Contract(int contractNumber, int bookingNumber, double deposit, double totalPayment, int customerId) {
        this.contractNumber = contractNumber;
        this.bookingNumber = bookingNumber;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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



    @Override
    public String toString() {
        return "contractNumber=" + contractNumber +
                ", bookingNumber=" + bookingNumber +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerId=" + customerId ;
    }

    @Override
    public int compareTo(Contract o) {
        return (int) (this.bookingNumber-o.bookingNumber);
    }
}
