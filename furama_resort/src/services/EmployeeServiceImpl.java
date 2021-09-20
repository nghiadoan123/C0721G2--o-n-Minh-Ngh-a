package services;

import models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl {
    private static List<Employee> employeeServices = new ArrayList<Employee>();

    static {
        employeeServices.add(new Employee(1,"A", "20/12/2020", "men", 1234567891, "09051235891", "abc1@gmail.com","manager", 20000.0));
        employeeServices.add(new Employee(2,"Ab", "22/12/2020", "women", 1234567892, "09051235892", "abc2@gmail.com","service", 18000.0));
        employeeServices.add(new Employee(3,"Abc", "24/12/2020", "men", 1234567893, "09051235893", "abc3@gmail.com","superviser", 16000.0));
        employeeServices.add(new Employee(4,"Abcd", "26/12/2020", "women", 1234567894, "09051235894", "abc4@gmail.com","reception", 10000.0));

    }

    public void addNewEmployeeManagement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input employee id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("input employee name:");
        String name = sc.next();
        System.out.println("input employee day of birth:");
        String dayOfBirth = sc.next();
        System.out.println("input employee gender:");
        String gender = sc.next();
        System.out.println("input employee identyty number:");
        int identityNumber = sc.nextInt();
        System.out.println("input employee phone number:");
        String phoneNumber = sc.next();
        System.out.println("input employee email:");
        String email = sc.next();
        System.out.println("input employee position:");
        String position = sc.next();
        System.out.println("input employee salary:");
        double salary = sc.nextDouble();
        Employee employee = new Employee(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email, position, salary);
        employeeServices.add(employee);
        System.out.println("after add new employee");
        displayEmployeeManagement();
    }

    public void editEmployee() {
        displayEmployeeManagement();
        System.out.println("input id need to edit");
        Scanner sc = new Scanner(System.in);
        int chooseId = sc.nextInt();
        System.out.println("input employee name");
        employeeServices.get(chooseId - 1).setName(sc.next());
        System.out.println(" input employee day of birth");
        employeeServices.get(chooseId - 1).setDayOfBirth(sc.next());
        System.out.println("input employee gender ");
        employeeServices.get(chooseId - 1).setGender(sc.next());
        System.out.println("input employee identyty number:");
        employeeServices.get(chooseId - 1).setIdentityNumber(sc.nextInt());
        System.out.println("input employee phone number:");
        employeeServices.get(chooseId - 1).setPhoneNumber(sc.next());
        System.out.println("input employee email: ");
        employeeServices.get(chooseId - 1).setEmail(sc.next());
        System.out.println("input employee position: ");
        employeeServices.get(chooseId - 1).setPosition(sc.next());
        System.out.println("input employee salary: ");
        employeeServices.get(chooseId - 1).setSalary(Double.parseDouble(sc.nextLine()));
        System.out.println("employee information after edit:");
        displayEmployeeManagement();
    }

    public void displayEmployeeManagement() {
        for (int i = 0; i <employeeServices.size() ; i++) {
            System.out.println(employeeServices.get(i));
        }
    }
}
