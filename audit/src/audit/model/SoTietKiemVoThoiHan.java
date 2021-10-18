package audit.model;

public class SoTietKiemVoThoiHan extends SoTietKiem{
    private double soTienGui;
    private int laiXuat;

    public SoTietKiemVoThoiHan() {
    }

    public SoTietKiemVoThoiHan(String maSoXo, String maKhachHang, String ngayMoSo, String thoiGianBatDau, double soTienGui, int laiXuat) {
        super(maSoXo, maKhachHang, ngayMoSo, thoiGianBatDau);
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
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

    @Override
    public String toString() {
        return "SoTietKiemVoThoiHan{" +
                super.toString()+
                "soTienGui=" + soTienGui +
                ", laiXuat=" + laiXuat +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getMaSoXo()+","+super.getMaKhachHang()+","+super.getNgayMoSo()+","+super.getThoiGianBatDau()+","+soTienGui+","+laiXuat;
    }
}
