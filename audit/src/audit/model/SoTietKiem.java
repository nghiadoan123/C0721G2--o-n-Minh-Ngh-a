package audit.model;

public abstract class SoTietKiem {

    private String maSoXo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoiGianBatDau;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSoXo, String maKhachHang, String ngayMoSo, String thoiGianBatDau) {
        this.maSoXo = maSoXo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getMaSoXo() {
        return maSoXo;
    }

    public void setMaSoXo(String maSoXo) {
        this.maSoXo = maSoXo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "maSoXo='" + maSoXo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianBatDau='" + thoiGianBatDau + '\'' +
                '}';
    }

    public String getInfoToCSV(){
        return "";
    }

}
