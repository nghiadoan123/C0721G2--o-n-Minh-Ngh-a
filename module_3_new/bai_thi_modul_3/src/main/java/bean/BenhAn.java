package bean;

public class BenhAn {
    private String id;
    private String tenBenhAn;

    public BenhAn() {
    }

    public BenhAn(String id, String tenBenhAn) {
        this.id = id;
        this.tenBenhAn = tenBenhAn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }
}
