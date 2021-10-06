package phuong_tien_giao_thong.models.phuong_tien;

public class XeMay extends PhuongTien implements Comparable<XeMay>{
    private double congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHangSanXuat, String namSanxuat, String chuSoHuu, double congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanxuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                super.toString()+
                "congSuat=" + congSuat +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getBienKiemSoat() + "," + super.getTenHangSanXuat() + "," + super.getNamSanxuat() + "," + super.getChuSoHuu() + "," + congSuat;
    }

    @Override
    public int compareTo(XeMay o) {
        return this.getBienKiemSoat().compareTo(o.getBienKiemSoat());
    }
}
