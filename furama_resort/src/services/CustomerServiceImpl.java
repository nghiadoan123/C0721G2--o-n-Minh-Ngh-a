package services;

import models.person.Customer;
import services.input.InputCustomer;
import services.input.InputPerson;
import utils.CustomerReadAndWriteFileToCSV;

import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    //EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\customerdata.csv";
    public static List<Customer> customerList = CustomerReadAndWriteFileToCSV.readListCustomerFromCSV(FILE_PATH);
    Scanner sc = new Scanner(System.in);

//    static {
//        Customer customer1 = new Customer("1", "Steven", "19/2/1298", "man", 906959, "Steven@gmail.com", "C101", "Member", "Newyork");
//        Customer customer2 = new Customer("2", "job", "20/02/2002", "woman", 906979, "Jonh@gmail.com", "C102", "Silver", "Canada");
//        Customer customer3 = new Customer("3", "angela", "12/02/2014", "man", 906958, "Anna@gmail.com", "C103", "Member", "US");
//        customerList.add(customer1);
//        customerList.add(customer2);
//        customerList.add(customer3);
//    }

    public final static String DIAMOND = "Diamond";
    public final static String PLATINUM = "Platinum";
    public final static String GOLD = "Gold";
    public final static String SILVER = "Silver";
    public final static String MEMBER = "Member";

    @Override
    public void add() {
        String id = InputPerson.inputId();
        String name = InputPerson.inputName();
        String dayOfBirth = InputPerson.inputBirthday();
        String gender = InputPerson.inputGender();
        int identityNumber = InputPerson.identityNumber();
        String phoneNumber = InputPerson.phoneNumber();
        String email = InputPerson.emailInput();
        System.out.print("input customer type:");
        String typeOfCustomer = selectTypeOfCustomer();
        String address = InputCustomer.address();
        Customer customer = new Customer(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email, typeOfCustomer, address);
        customerList.add(customer);
        CustomerReadAndWriteFileToCSV.writeListCustomerToCSV(customerList, FILE_PATH, false);
//        System.out.println("after add new employee");
//        showList();
    }

    public String selectTypeOfCustomer() {
        System.out.println("Enter type of customer" + "\n" + "1.DIAMOND" + "\n" + "2.PLATINUM" + "\n" + "3.GOLD" + "\n" + "4.SILVER" + "\n" + "4.MEMBER");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        while (true) {
            switch (choose) {
                case "1":
                    return Customer.DIAMOND;
                case "2":
                    return Customer.PLATINUM;
                case "3":
                    return Customer.GOLD;
                case "4":
                    return Customer.SILVER;
                case "5":
                    return Customer.MEMBER;
                default:
                    System.out.println("in put again");
            }
        }
    }

    public void editCustomer() {
        System.out.println("show customer before edit:");
        showList();
        System.out.println("Enter name of customer to edit !");
        String name = sc.nextLine();
        for (Customer customer : customerList) {
            if (customer.getName().equals(name)) {
                boolean flag = true;
                while (flag) {
                    System.out.println("1 Edit id \n" + "2 Edit name" + "\n" + "3 Edit birthday" + "\n" + "4 Edit gender" + "\n" + "5 Edit identity number" + "\n" + "6 Edit phoneNumber" + "\n" + "7 Edit email" + "\n" + "8 Edit typeOfCustomer" + "\n" + "9 Edit address" + "\n" + "10 Finish edit");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new ID");
                            String ID = InputPerson.inputId();
                            customer.setId(ID);
                            break;
                        case 2:
                            System.out.println("Enter new name");
                            String name1 = InputPerson.inputName();
                            customer.setName(name1);
                            break;
                        case 3:
                            System.out.println("Enter new birthday");
                            String birthday = InputPerson.inputBirthday();
                            customer.setDayOfBirth(birthday);
                            break;
                        case 4:
                            System.out.println("Enter new gender");
                            String gender = sc.nextLine();
                            customer.setGender(gender);
                            break;
                        case 5:
                            System.out.println("Enter new identity number");
                            int identity = InputPerson.identityNumber();
                            customer.setIdentityNumber(identity);
                            break;
                        case 6:
                            System.out.println("Enter new phoneNumber");
                            String phoneNumber = InputPerson.phoneNumber();
                            customer.setPhoneNumber(phoneNumber);
                            break;
                        case 7:
                            System.out.println("Enter new email");
                            String email = InputPerson.emailInput();
                            customer.setEmail(email);
                            break;
                        case 8:
                            boolean flagType = true;
                            while (flagType) {
                                System.out.println("Enter new typeOfCustomer" + "\n" + "1.DIAMOND" + "\n" + "2.PLATINUM" + "\n" + "3.GOLD" + "\n" + "4.SILVER" + "\n" + "5.MEMBER");
                                int choice1 = sc.nextInt();
                                switch (choice1) {
                                    case 1:
                                        customer.setTypeOfCustomer(Customer.DIAMOND);
                                        flagType = false;
                                        break;
                                    case 2:
                                        customer.setTypeOfCustomer(Customer.PLATINUM);
                                        flagType = false;
                                        break;
                                    case 3:
                                        customer.setTypeOfCustomer(Customer.GOLD);
                                        flagType = false;
                                        break;
                                    case 4:
                                        customer.setTypeOfCustomer(Customer.SILVER);
                                        flagType = false;
                                        break;
                                    case 5:
                                        customer.setTypeOfCustomer(Customer.MEMBER);
                                        flagType = false;
                                        break;
                                    default:
                                        System.out.println("input again");
                                }
                            }
                            break;
                        case 9:
                            System.out.println("Enter new address");
                            String address = InputCustomer.address();
                            customer.setAddress(address);
                            break;
                        case 10:
                            flag = false;
                    }
                }
            }
        }
        CustomerReadAndWriteFileToCSV.writeListCustomerToCSV(customerList, FILE_PATH, false);
    }

    public static void setCustomer(String id) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Enter customer name :");
        String name = scanner.nextLine();
        for (Customer customer : customerList) {
            if (customer.getName().equals(name)) {
                System.out.println(customer);
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("Not found !");
        }
    }

    @Override
    public void showList() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }



}
