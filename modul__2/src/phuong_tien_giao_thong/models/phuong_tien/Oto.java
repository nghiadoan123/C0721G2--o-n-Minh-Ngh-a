package phuong_tien_giao_thong.models.phuong_tien;

public class Oto extends PhuongTien implements Comparable<PhuongTien>{

    private int soChoNgoi;
    private String kieuXe;

    public final static String KIEU_DU_LICH = "Du lich";
    public final static String KIEU_XE_KHACH = "Xe khach";

    public Oto() {
    }

    public Oto(String bienKiemSoat, String tenHangSanXuat, String namSanxuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanxuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getBienKiemSoat() + "," + super.getTenHangSanXuat() + "," + super.getNamSanxuat() + "," + super.getChuSoHuu() + "," + soChoNgoi + "," + kieuXe;
    }

    @Override
    public int compareTo(PhuongTien o) {
        return this.getBienKiemSoat().compareTo(o.getBienKiemSoat());
    }
}
