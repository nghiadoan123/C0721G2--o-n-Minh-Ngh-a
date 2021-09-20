package models;

public class Contract {
    private double contractNumber;
    private double bookingNumber;
    private double deposit;
    private double totalPayment;
    private double customerId;

    public Contract() {
    }

    public Contract(double contractNumber, double bookingNumber, double deposit, double totalPayment, double customerId) {
        this.contractNumber = contractNumber;
        this.bookingNumber = bookingNumber;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public double getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(double contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(double bookingNumber) {
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

    public double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(double customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "contractNumber=" + contractNumber +
                ", bookingNumber=" + bookingNumber +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerId=" + customerId ;
    }
}
