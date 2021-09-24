package services;

import models.person.Customer;
import models.person.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static List<Customer> customerList = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public final static String DIAMOND = "Diamond";
    public final static String PLATINUM = "Platinum";
    public final static String GOLD = "Gold";
    public final static String SILVER = "Silver";
    public final static String MEMBER = "Member";


    @Override
    public void add() {
        System.out.println("input customer id:");
        String id = sc.next();
        System.out.println("input customer name:");
        String name = sc.next();
        System.out.println("input customer day of birth:");
        String dayOfBirth = sc.next();
        System.out.println("input customer gender:");
        String gender = sc.next();
        System.out.println("input customer identyty number:");
        int identityNumber = sc.nextInt();
        System.out.println("input customer phone number:");
        String phoneNumber = sc.next();
        System.out.println("input customer email:");
        String email = sc.next();
        System.out.println("input type of customer :");
        String typeOfCustomer = selectTypeOfCustomer();
        System.out.println("input customer address:");
        String address = sc.next();
        Customer customer = new Customer(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email, typeOfCustomer, address);
        customerList.add(customer);
        System.out.println("after add new employee");
        showList();
    }

    public String selectTypeOfCustomer() {
        String choose = sc.next();
        while (true) {
            System.out.println("Enter type of customer" + "\n" + "1.DIAMOND" + "\n" + "2.PLATINUM" + "\n" + "3.GOLD" + "\n" + "4.SILVER" + "\n" + "4.MEMBER");
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
                            String ID = sc.nextLine();
                            customer.setId(ID);
                            break;
                        case 2:
                            System.out.println("Enter new name");
                            String name1 = sc.nextLine();
                            customer.setName(name1);
                            break;
                        case 3:
                            System.out.println("Enter new birthday");
                            String birthday = sc.nextLine();
                            customer.setName(birthday);
                            break;
                        case 4:
                            System.out.println("Enter new gender");
                            String gender = sc.nextLine();
                            customer.setName(gender);
                            break;
                        case 5:
                            System.out.println("Enter new identity number");
                            String identity = sc.nextLine();
                            customer.setName(identity);
                            break;
                        case 6:
                            System.out.println("Enter new phoneNumber");
                            String phoneNumber = sc.nextLine();
                            customer.setName(phoneNumber);
                            break;
                        case 7:
                            System.out.println("Enter new email");
                            String email = sc.nextLine();
                            customer.setName(email);
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
                            String address = sc.nextLine();
                            customer.setName(address);
                            break;
                        case 10:
                            flag = false;
                    }
                }
            }
        }
    }

    @Override
    public void showList() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }
    }


    @Override
    public void search() {

    }

    @Override
    public void delete() {

    }
}
