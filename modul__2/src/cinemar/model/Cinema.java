package cinemar.model;

public class Cinema implements Comparable<Cinema>{
   private String maXuatChieuPhim;
   private String tenPhim;
   private String ngayChieu;
   private int soLuongVe;

    public Cinema() {
    }

    public Cinema(String maXuatChieuPhim, String tenPhim, String ngayChieu, int soLuongVe) {
        this.maXuatChieuPhim = maXuatChieuPhim;
        this.tenPhim = tenPhim;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
    }

    public String getMaXuatChieuPhim() {
        return maXuatChieuPhim;
    }

    public void setMaXuatChieuPhim(String maXuatChieuPhim) {
        this.maXuatChieuPhim = maXuatChieuPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "maXuatChieuPhim='" + maXuatChieuPhim + '\'' +
                ", tenPhim='" + tenPhim + '\'' +
                ", ngayChieu='" + ngayChieu + '\'' +
                ", soLuongVe=" + soLuongVe +
                '}';
    }


    public String getInfoToCSV() {
        return maXuatChieuPhim+","+tenPhim+","+ngayChieu+","+soLuongVe;
    }

    @Override
    public int compareTo(Cinema o) {
        return this.maXuatChieuPhim.compareTo(o.maXuatChieuPhim);
    }
}
