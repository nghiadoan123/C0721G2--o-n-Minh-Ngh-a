package electric_bill.models.bill;

public class Bill implements Comparable<Bill> {

    private String idBill;
    private String dayOFfBill;
    private int numberOfElectric;
    private double unitPrice;
    public static int num =0;
    private double total;

    public Bill() {
    }

    public Bill(String idBill, String dayOFfBill, int numberOfElectric, double unitPrice) {
        this.idBill = idBill;
        this.dayOFfBill = dayOFfBill;
        this.numberOfElectric = numberOfElectric;
        this.unitPrice = unitPrice;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public double getTotal() {
        if (this.getNumberOfElectric() < 100) {
            total = numberOfElectric * unitPrice;
        } else if (this.getNumberOfElectric() > 100) {
            total = (numberOfElectric * unitPrice * 100) + (numberOfElectric - 100) * unitPrice * 2.5;
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDayOFfBill() {
        return dayOFfBill;
    }

    public void setDayOFfBill(String dayOFfBill) {
        this.dayOFfBill = dayOFfBill;
    }

    public int getNumberOfElectric() {
        return numberOfElectric;
    }

    public void setNumberOfElectric(int numberOfElectric) {
        this.numberOfElectric = numberOfElectric;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill='" + idBill + '\'' +
                ", dayOFfBill='" + dayOFfBill + '\'' +
                ", numberOfElectric=" + numberOfElectric +
                ", unitPrice=" + unitPrice +
                ", total=" + total+
                '}';
    }

    public String getInfoToCSV() {
        return idBill + "," + dayOFfBill + "," + numberOfElectric + "," + unitPrice + "," + this.getTotal();
    }

    @Override
    public int compareTo(Bill o) {
        return this.dayOFfBill.compareTo(o.dayOFfBill);
    }
}
