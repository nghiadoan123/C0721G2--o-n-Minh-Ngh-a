package phuong_tien_giao_thong.models.phuong_tien;

public class HangSanXuat {
    private String maSanXuat;
    private String hangSanXuat;
    private String nuocSanXuat;

    public HangSanXuat() {
    }

    public HangSanXuat(String maSanXuat, String hangSanXuat, String nuocSanXuat) {
        this.maSanXuat = maSanXuat;
        this.hangSanXuat = hangSanXuat;
        this.nuocSanXuat = nuocSanXuat;
    }

    public String getMaSanXuat() {
        return maSanXuat;
    }

    public void setMaSanXuat(String maSanXuat) {
        this.maSanXuat = maSanXuat;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    @Override
    public String toString() {
        return "HangSanXuat{" +
                "maSanXuat='" + maSanXuat + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", nuocSanXuat='" + nuocSanXuat + '\'' +
                '}';
    }
}
