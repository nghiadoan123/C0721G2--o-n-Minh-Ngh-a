package electric_bill.models.customer;

public class ForengCustomer extends Customer {

    private String countryName;

    public ForengCustomer() {
    }

    public ForengCustomer(String id, String name, String countryName) {
        super(id, name);
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "ForengCustomer{" +
                super.toString()+
                "countryName='" + countryName + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV(){
        return super.getId()+","+super.getName()+","+countryName;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getId().compareTo(o.getId());
    }
}
