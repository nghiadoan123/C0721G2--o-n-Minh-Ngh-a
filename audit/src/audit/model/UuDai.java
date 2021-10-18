package audit.model;

public class UuDai {
    private String uuDai;

    public UuDai() {
    }

    public UuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return "UuDai{" +
                "uuDai='" + uuDai + '\'' +
                '}';
    }


}
