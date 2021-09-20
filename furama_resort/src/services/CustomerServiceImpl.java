package services;

import models.Customer;
import models.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl {
    private static List<Customer> customerList = new LinkedList<>();

    static {
        customerList.add(new Customer( 1,"A", "2/2/2012", "man", 124563, "0169875", "abc@gmail.com", "Diamond", "dn"));
        customerList.add(new Customer( 2,"B", "4/2/2012", "woman", 124563, "0169875", "abc@gmail.com", "Platinium", "hue"));
        customerList.add(new Customer(3,"C", "6/2/2012", "man", 124563, "0169875", "abc@gmail.com", "Gold", "sg"));
        customerList.add(new Customer( 4,"D", "8/2/2012", "woman", 124563, "0169875", "abc@gmail.com", "Silver", "hn"));
        customerList.add(new Customer( 5,"E", "10/2/2012", "man", 124563, "0169875", "abc@gmail.com", "Member", "qn"));
    }

    public void addNewCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input customer id:");
        int id = Integer.parseInt(sc.nextLine());
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
        String typeOfCustomer = sc.next();
        System.out.println("input customer address:");
        String address = sc.next();
        Customer customer = new Customer(id,name, dayOfBirth, gender, identityNumber, phoneNumber, email, typeOfCustomer, address);
        customerList.add(customer);
        System.out.println("after add new employee");
        displayCustomer();
    }

    public void editCustomer() {
        displayCustomer();
        System.out.println("input id need to edit");
        Scanner sc = new Scanner(System.in);
        int chooseId = sc.nextInt();
        System.out.println("input customer name");
        customerList.get(chooseId - 1).setName(sc.next());
        System.out.println(" input customer day of birth");
        customerList.get(chooseId - 1).setDayOfBirth(sc.next());
        System.out.println("input customer gender ");
        customerList.get(chooseId - 1).setGender(sc.next());
        System.out.println("input customer identyty number:");
        customerList.get(chooseId - 1).setIdentityNumber(sc.nextInt());
        System.out.println("input customer phone number:");
        customerList.get(chooseId - 1).setPhoneNumber(sc.next());
        System.out.println("input customer email: ");
        customerList.get(chooseId - 1).setEmail(sc.next());
        System.out.println("input type of customer : ");
        customerList.get(chooseId - 1).setTypeOfCustomer(sc.next());
        System.out.println("input customer address: ");
        customerList.get(chooseId - 1).setAddress(sc.next());
        System.out.println("customer information after edit:");
        displayCustomer();

    }

    public void displayCustomer() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }

    }
}
