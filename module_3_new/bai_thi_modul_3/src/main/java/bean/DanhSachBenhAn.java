package bean;

public class DanhSachBenhAn {
    private  int id;
    private BenhAn idBenhAn;
    private BenhNhan idBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDo;

    public DanhSachBenhAn() {
    }

    public DanhSachBenhAn(int id, BenhAn idBenhAn, BenhNhan idBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDo) {
        this.id = id;
        this.idBenhAn = idBenhAn;
        this.idBenhNhan = idBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BenhAn getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(BenhAn idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public BenhNhan getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(BenhNhan idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }


}
