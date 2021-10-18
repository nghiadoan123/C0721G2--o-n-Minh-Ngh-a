package audit.model;

public class SoTietKiemDaiHan extends SoTietKiem{

    private  int kyHan;
    private double soTienGui;
    private int laiXuat;
    private String uuDai;


    public SoTietKiemDaiHan() {
    }

    public SoTietKiemDaiHan(String maSoXo, String maKhachHang, String ngayMoSo, String thoiGianBatDau, int kyHan, double soTienGui, int laiXuat, String uuDai) {
        super(maSoXo, maKhachHang, ngayMoSo, thoiGianBatDau);
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
        this.uuDai = uuDai;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public int getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(int laiXuat) {
        this.laiXuat = laiXuat;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return "SoTietKiemDaiHan{" +
                super.toString()+
                "kyHan=" + kyHan +
                ", soTienGui=" + soTienGui +
                ", laiXuat=" + laiXuat +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getMaSoXo()+","+super.getMaKhachHang()+","+super.getNgayMoSo()+","+super.getThoiGianBatDau()+","+kyHan+","+soTienGui+","+laiXuat+","+uuDai;
    }
}
