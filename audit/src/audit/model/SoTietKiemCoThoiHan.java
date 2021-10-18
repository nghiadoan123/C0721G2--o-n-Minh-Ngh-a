package audit.model;

public class SoTietKiemCoThoiHan extends SoTietKiem{
    
    private int kyHan;
    private double soTienGui;
    private int laiXuat;

    public SoTietKiemCoThoiHan() {
    }

    public SoTietKiemCoThoiHan(String maSoXo, String maKhachHang, String ngayMoSo, String thoiGianBatDau, int kyHan, double soTienGui, int laiXuat) {
        super(maSoXo, maKhachHang, ngayMoSo, thoiGianBatDau);
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
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

    @Override
    public String 
    toString() {
        return "SoTietKiemCoThoiHan{" +
                super.toString()+
                "kyHan=" + kyHan +
                ", soTienGui=" + soTienGui +
                ", laiXuat=" + laiXuat +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getMaSoXo()+","+super.getMaKhachHang()+","+super.getNgayMoSo()+","+super.getThoiGianBatDau()+","+kyHan+","+soTienGui+","+laiXuat;
    }
    
}
