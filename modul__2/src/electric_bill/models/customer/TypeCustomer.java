package electric_bill.models.customer;

public class TypeCustomer {

    private String typeOfCustomer;
    private String useType;

    public TypeCustomer() {
    }

    public TypeCustomer(String typeOfCustomer, String useType) {
        this.typeOfCustomer = typeOfCustomer;
        this.useType = useType;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Override
    public String toString() {
        return "TypeCustomer{" +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", useType='" + useType + '\'' +
                '}';
    }


}
