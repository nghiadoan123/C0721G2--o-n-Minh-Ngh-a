package phuong_tien_giao_thong.models.phuong_tien;

public class XeTai extends PhuongTien implements Comparable<XeTai>{
    private double trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHangSanXuat, String namSanxuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanxuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                super.toString()+
                "trongTai=" + trongTai +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getBienKiemSoat() + "," + super.getTenHangSanXuat() + "," + super.getNamSanxuat() + "," + super.getChuSoHuu() + "," + trongTai;
    }

    @Override
    public int compareTo(XeTai o) {
        return this.getBienKiemSoat().compareTo(o.getBienKiemSoat());
    }
}
