package bean;

public class BenhNhan {

    private  String id;
    private String tenBenh;

    public BenhNhan() {
    }

    public BenhNhan(String id, String tenBenh) {
        this.id = id;
        this.tenBenh = tenBenh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }
}
