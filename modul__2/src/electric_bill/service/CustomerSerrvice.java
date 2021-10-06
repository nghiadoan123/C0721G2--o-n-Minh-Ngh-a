package electric_bill.service;

import electric_bill.models.customer.Customer;
import electric_bill.models.customer.ForengCustomer;
import electric_bill.models.customer.TypeCustomer;
import electric_bill.models.customer.VietNamCustomer;
import electric_bill.models.input.Input;
import electric_bill.untils.CustomerReadAndWriteToCSV;
import electric_bill.untils.CustomerTypeReadToCSV;

import java.util.*;

public class CustomerSerrvice implements Service {

    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\electric_bill\\data\\khachHang.csv";
    public static final String TYPE_CUSTOMER_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\src\\electric_bill\\data\\loaiKhach.csv";
    public static ArrayList<TypeCustomer> typeCustomers = CustomerTypeReadToCSV.readFromCSV(TYPE_CUSTOMER_FILE_PATH);
    public static TreeSet<Customer> customerArrayList = CustomerReadAndWriteToCSV.readListFromCSV(FILE_PATH);


    @Override
    public void add() {
        for (TypeCustomer typeCustomer: typeCustomers) {
            System.out.println(typeCustomer);
        }
        boolean flag = true;
        System.out.println("Enter your choice" + "\n" + "1.thêm khvn" + "\n" + "2.thêm khnn" + "\n" + "3.Back to Menu");
        while (flag) {
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    String id = Input.inputIDKHVN();
                    String name = Input.inputName();
                    String typeOfCustomer = Input.inputTypeOfCustomer();
                    double useElectric =  Input.useElectric();
                    VietNamCustomer vietNamCustomer = new VietNamCustomer(id,name,typeOfCustomer,useElectric);
                    customerArrayList.add(vietNamCustomer);
                    CustomerReadAndWriteToCSV.writeListToCSV(customerArrayList,FILE_PATH,false);
                    flag = false;
                    break;
                case "2":
                    String idNN = Input.inputIDKHNN();
                    String nameNN = Input.inputName();
                    String country = Input.inputCountry();
                    ForengCustomer forengCustomer = new ForengCustomer(idNN,nameNN,country);
                    customerArrayList.add(forengCustomer);
                    CustomerReadAndWriteToCSV.writeListToCSV(customerArrayList,FILE_PATH,false);
                    flag = false;
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("enter again:");
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        for (Customer customer : customerArrayList) {
            System.out.println(customer);
        }
    }

    public void searchCustomer(){
        Scanner scanner = new Scanner(System.in);
        String name = Input.inputName();
        for (Customer customer : customerArrayList) {
           if (customer.getName().equals(name)){
               System.out.println(customer);
               return;
           }
        }
        System.out.println("not found");
    }
}
