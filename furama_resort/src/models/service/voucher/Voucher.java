package models.service.voucher;

public class Voucher {
    public static final String VOUCHER_10 = "voucher 10%";
    public static final String VOUCHER_20 = "voucher 20%";
    public static final String VOUCHER_50 = "voucher 50%";
    private String voucherType;


    public Voucher() {
    }

    public Voucher(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "voucherType='" + voucherType + '\'' +
                '}';
    }
}
