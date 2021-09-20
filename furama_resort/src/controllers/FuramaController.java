package controllers;

import models.Customer;
import services.BookingServiceImpl;
import services.CustomerServiceImpl;
import services.EmployeeServiceImpl;
import services.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        CustomerServiceImpl  customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
        boolean flag = true;
        boolean flagEmployee = false;
        boolean flagCustomer = false;
        boolean flagFacility = false;
        boolean flagBooking = false;
        boolean flagService = false;


        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Employee Management\n" +
                    "2.Customer Management\n" +
                    "3.Facility Management \n" +
                    "4.Booking Management\n" +
                    "5.Promotion Management\n" +
                    "6.Exit");
            System.out.println("Chọn");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.Display list employees\n" +
                                "2.Add new employee\n" +
                                "3.Edit employee \n" +
                                "4.Return main menu\n" );
                        int chooseCase1 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase1){
                            case 1:
                                //Display list employees
                                employeeService.displayEmployeeManagement();
                                break;
                            case 2:
                                //	Add new employee
                                employeeService.addNewEmployeeManagement();
                                break;
                            case 3:
                                //	Edit employee
                                employeeService.editEmployee();

                                break;
                            case 4:
                                //	Return main menu
                                flagEmployee = true;
                                break;
                        }
                    }while (!flagEmployee);
                    break;
                case 2:
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.Display list customers\n" +
                                "2.Add new customer\n" +
                                "3.Edit customer \n" +
                                "4.Return main menu\n" );
                        int chooseCase2 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase2){
                            case 1:
                                customerService.displayCustomer();
                                break;
                            case 2:
                                customerService.addNewCustomer();
                                break;
                            case 3:
                                customerService.editCustomer();
                                break;
                            case 4:
                                //	Return main menu
                                flagCustomer = true;
                                break;
                        }
                    }while (!flagCustomer);

                    break;
                case 3:
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.Display list facility\n" +
                                "2.Add new facility\n" +
                                "3.Display list facility maintenance \n" +
                                "4.Return main menu\n" );
                        int chooseCase3 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase3){
                            case 1:
                                facilityService.displayFacility();
                                break;
                            case 2:
                                facilityService.addFacility();
                                break;
                            case 3:
                                facilityService.facilityMaintenance();
                                break;
                            case 4:
                                //	Return main menu
                                break;
                        }
                    }while (!flagFacility);

                    break;
                case 4:
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.Add new booking\n" +
                                "2.Display list booking\n" +
                                "3.Create new constracts \n" +
                                "4.Display list contracts \n" +
                                "5.Edit contracts \n" +
                                "6.Return main menu\n" );
                        int chooseCase4 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase4){
                            case 1:
                                bookingService.addNewBooking();
                                break;
                            case 2:
                                bookingService.showBookingList();
                                break;
                            case 3:
                                System.out.println("3.Create new constracts");

                                break;
                            case 4:
                                System.out.println("4.Display list contracts");
                                break;
                            case 5:
                                System.out.println("5.Edit contracts");
                                break;
                            case 6:
                                //	Return main menu
                                break;
                        }
                    }while (!flagBooking);

                    break;
                case 5:
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.Display list customers use service\n" +
                                "2.Display list customers get voucher\n" +
                                "3.Return main menu\n" );
                        int chooseCase5 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase5){
                            case 1:
                                System.out.println("1.Display list customers use service");
                                break;
                            case 2:
                                System.out.println("2.Display list customers get voucher");
                                break;
                            case 3:
                                //	Return main menu
                                break;
                        }
                    }while (!flagService);

                    break;
                case 6:
                    flag = false;
            }
        }

    }
    public static void main(String[] args) {
        displayMainMenu();
    }

}
