package services;

import models.person.Employee;
import services.input.InputDayForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Employee> employeeServices = new ArrayList<Employee>();



    static {
        employeeServices.add(new Employee("AA116","Nam", "1990", "Male", 204331, "1990", "nam@gmail.com",  Employee.INTERMEDIATE, Employee.RECEPTION, 12000.0));
        employeeServices.add(new Employee("AA110","Long", "1990", "Male", 204332, "1991", "Long@gmail.com",  Employee.AFFTERUNIVERSITY, Employee.SUPERVIOR, 10000.0));
        employeeServices.add(new Employee("AA112","Lam", "1990", "Male", 204333, "06089542", "lam@gmail.com",  Employee.COLLEGE, Employee.WAITERS, 6000.0));
    }



    @Override
    public void add() {
        System.out.println("input employee name:");
        String name = scanner.nextLine();
        System.out.println("input employee day of birth:");
        String dayOfBirth = InputDayForm.inputBirthday();
        System.out.println("input employee gender:");
        String gender = scanner.nextLine();
        System.out.println("input employee identyty number:");
        int identityNumber = Integer.parseInt( scanner.nextLine());
        System.out.println("input employee phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("input employee email:");
        String email = scanner.nextLine();
        System.out.println("input employee id:");
        String id = scanner.nextLine();
        System.out.println("input employee degree:");
        String degree = chooseLevel();
        System.out.println("input employee position:");
        String position = choosePosition();
        System.out.println("input employee salary:");
        double salary =Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email, degree, position, salary);
        employeeServices.add(employee);
        System.out.println("after add new employee");
        showList();
    }

    public String choosePosition() {
        System.out.println("Enter level" + "\n" + "1.INTERMEDIATE" + "\n" + "2.COLLEGE" + "\n" + "3.UNIVERSITY" + "\n" + "4.AFFTERUNIVERSITY");
        String choice = scanner.nextLine();
        while (true)
            switch (choice) {
                case "1":
                    return Employee.INTERMEDIATE;
                case "2":
                    return Employee.COLLEGE;
                case "3":
                    return Employee.UNIVERSITY;
                case "4":
                    return Employee.AFFTERUNIVERSITY;
                default:
                    System.out.println("in put again");
            }
    }

    public String chooseLevel() {
        System.out.println("Enter level" + "\n" + "1.RECEPTION" + "\n" + "2.WAITERS" + "\n" + "3.EXPERT" + "\n" + "4.SUPERVIOR" + "\n" + "5.MANAGER" + "\n" + "6.GENERAL");
        String choice = scanner.nextLine();
        while (true)
            switch (choice) {
                case "1":
                    return Employee.RECEPTION;
                case "2":
                    return Employee.WAITERS;
                case "3":
                    return Employee.EXPERT;
                case "4":
                    return Employee.SUPERVIOR;
                case "5":
                    return Employee.MANAGER;
                case "6":
                    return Employee.GENERAL;
                default:
                    System.out.println("in put again");
            }
    }

    public void editEmployee() {
        System.out.println("Enter name of employee to edit !");
        String name = scanner.nextLine();
        for (Employee e : employeeServices) {
            if (e.getName().equals(name)) {
                boolean flagCheck = true;
                while (flagCheck) {
                    System.out.println("1 Edit id \n" + "2 Edit name" + "\n" + "3 Edit birthday" + "\n" + "4 Edit gender" + "\n" + "5 Edit identity number" + "\n" + "6 Edit phoneNumber" + "\n" + "7 Edit email"  + "8 Edit level" + "\n" + "9 Edit position" + "\n" + "10 Edit salary" + "\n" + "11 Finish edit");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new ID");
                            String ID = scanner.nextLine();
                            e.setId(ID);
                            break;
                        case 2:
                            System.out.println("Enter new name");
                            String nameNew = scanner.nextLine();
                            e.setName(nameNew);
                            break;

                        case 3:
                            System.out.println("Enter new bithday");
                            String birth = InputDayForm.inputBirthday();
                            e.setDayOfBirth(birth);
                            break;

                        case 4:
                            System.out.println("Enter new gender");
                            String gender = scanner.nextLine();
                            e.setGender(gender);
                            break;

                        case 5:
                            System.out.println("Enter new identityNumber");
                            int identityNumber = Integer.parseInt(scanner.nextLine());
                            e.setIdentityNumber(identityNumber);
                            break;

                        case 6:
                            System.out.println("Enter new phone");
                            String phone = scanner.nextLine();
                            e.setPhoneNumber(phone);
                            break;
                        case 7:
                            System.out.println("Enter new email");
                            String email = scanner.nextLine();
                            e.setEmail(email);
                            break;
                        case 8:
                            boolean flag = true;
                            while (flag) {
                                System.out.println("Enter new level" + "\n" + "1.INTERMEDIATE" + "\n" + "2.COLLEGE" + "\n" + "3.UNIVERSITY" + "\n" + "4.AFFTERUNIVERSITY");
                                String choice1 = scanner.nextLine();
                                switch (choice1) {
                                    case "1":
                                        e.setLevel(Employee.INTERMEDIATE);
                                        flag = false;
                                        break;
                                    case "2":
                                        e.setLevel(Employee.COLLEGE);
                                        flag = false;
                                        break;
                                    case "3":
                                        e.setLevel(Employee.UNIVERSITY);
                                        flag = false;
                                        break;
                                    case "4":
                                        e.setLevel(Employee.AFFTERUNIVERSITY);
                                        flag = false;
                                        break;
                                    default:
                                        System.out.println("input again");
                                        break;
                                }
                            }
                            break;
                        case 9:
                            boolean flagPosition = true;
                            while (flagPosition) {
                                System.out.println("Enter new position" + "\n" + "1.RECEPTION" + "\n" + "2.WAITERS" + "\n" + "3.EXPERT" + "\n" + "4.SUPERVIOR" + "\n" + "5.MANAGER" + "\n" + "6.GENERALMANAGER" + "\n");
                                int choice2 = scanner.nextInt();
                                switch (choice2) {
                                    case 1:
                                        e.setPosition(Employee.RECEPTION);
                                        flagPosition = false;
                                        break;
                                    case 2:
                                        e.setPosition(Employee.WAITERS);
                                        flagPosition = false;
                                        break;
                                    case 3:
                                        e.setPosition(Employee.EXPERT);
                                        flagPosition = false;
                                        break;
                                    case 4:
                                        e.setPosition(Employee.SUPERVIOR);
                                        flagPosition = false;
                                        break;
                                    case 5:
                                        e.setPosition(Employee.MANAGER);
                                        flagPosition = false;
                                        break;
                                    case 6:
                                        e.setPosition(Employee.GENERAL);
                                        flagPosition = false;
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }
                            }

                            break;
                        case 10:
                            System.out.println("Enter new Salary");
                            double salary = Double.parseDouble(scanner.nextLine());
                            e.setSalary(salary);
                            break;
                        case 11:
                            flagCheck = false;
                    }
                }
            }
        }
        System.out.println("after edit list:");
        showList();
    }

    @Override
    public void showList() {
        for (int i = 0; i < employeeServices.size(); i++) {
            System.out.println(employeeServices.get(i));
        }
    }

    @Override
    public void search() {

    }

    @Override
    public void delete() {

    }
}
