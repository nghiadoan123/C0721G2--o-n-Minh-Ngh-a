package phuong_tien_giao_thong.models.phuong_tien;

public abstract class PhuongTien {
    private String bienKiemSoat;
    private String tenHangSanXuat;
    private String namSanxuat;
    private String chuSoHuu;

    public PhuongTien() {
    }

    public PhuongTien(String bienKiemSoat, String tenHangSanXuat, String namSanxuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanxuat = namSanxuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getNamSanxuat() {
        return namSanxuat;
    }

    public void setNamSanxuat(String namSanxuat) {
        this.namSanxuat = namSanxuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "PhuongTien{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanxuat='" + namSanxuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }

    public String getInfoToCSV(){
        return "";
    }

}
