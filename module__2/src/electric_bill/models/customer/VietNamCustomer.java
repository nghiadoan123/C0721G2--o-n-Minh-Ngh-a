package electric_bill.models.customer;

public class VietNamCustomer extends Customer {

    private String typeOfCustomer;
    private double useElectric;

    public VietNamCustomer() {
    }

    public VietNamCustomer(String id, String name, String typeOfCustomer, double useElectric) {
        super(id, name);
        this.typeOfCustomer = typeOfCustomer;
        this.useElectric = useElectric;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public double getUseElectric() {
        return useElectric;
    }

    public void setUseElectric(double useElectric) {
        this.useElectric = useElectric;
    }

    @Override
    public String toString() {
        return "VietNamCustomer{" +
                super.toString()+
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", useElectric=" + useElectric +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getId()+","+super.getName()+","+typeOfCustomer+","+useElectric;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getId().compareTo(o.getId());
    }
}
