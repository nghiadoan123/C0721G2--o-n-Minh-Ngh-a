package services;

import models.person.Customer;
import models.service.facility.Facility;
import models.service.booking.Booking;
import services.input.InputDayForm;
import services.input.PersonInput;
import utils.BookingReadAndWriteFileToCSV;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner scanner = new Scanner(System.in);
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\booking.csv";
    public static final String FILE_PATH_LIST_ALL = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\bookinglist.csv";
    public static final String READ_FILE_PATH_LIST = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\readbookinglist.csv";

    public static TreeSet<Booking> bookingList = BookingReadAndWriteFileToCSV.readDataFromFile(FILE_PATH);
    public static TreeSet<Booking> bookingListAll = BookingReadAndWriteFileToCSV.readDataFromFile(FILE_PATH_LIST_ALL);
    public static TreeSet<Booking> bookingReadListAll = BookingReadAndWriteFileToCSV.readListBookingFromCSV(FILE_PATH_LIST_ALL);

    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    ContractServiceImpl contactService = new ContractServiceImpl();

    @Override
    public void add() throws Exception {
        customerService.showList();
        facilityService.showList();
        System.out.println("Enter customer ID");
        Customer customer = inputCustomer();
        if (customer == null) {
            return;
        } else {
            for (Booking booking : bookingList) {
                if (booking.getCustomer().getId().equals(customer.getId())) {
                    System.out.println("had booking");
                    System.out.println(booking);
                    return;
                }
            }
        }
        System.out.println("Enter service name");
        Facility facility = inputFacility();
        if (facility == null) {
            return;
        }
        System.out.println("Enter bookingID");
        String bookingID = scanner.nextLine();
        System.out.println("enter checkin day");
        Date checkinDay = PersonInput.inputCheckInOut();
        System.out.println("enter checkout day");
        Date checkoutDay = PersonInput.inputCheckInOut();
        Booking booking = new Booking(bookingID, checkinDay, checkoutDay, customer, facility);
        CustomerServiceImpl.customerList.remove(customer);
        String facilityName = facility.getServiceName();
        FacilityServiceImpl.facilityTime(facilityName);
        bookingList.add(booking);
        bookingListAll.add(booking);
        BookingReadAndWriteFileToCSV.writeToFile(bookingList, FILE_PATH);
        BookingReadAndWriteFileToCSV.writeToFile(bookingListAll, FILE_PATH_LIST_ALL);
        BookingReadAndWriteFileToCSV.writeListBookingToCSV(bookingListAll, READ_FILE_PATH_LIST, false);
        showBookingList();
    }

    public static Customer inputCustomer() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter customer ID");
            String customerID = scanner.nextLine();
            for (Customer customer : CustomerServiceImpl.customerList) {
                if (customerID.equals(customer.getId())) {
                    return customer;
                }
            }
            System.out.println("not found");
            return null;
        }

    }

    public static Facility inputFacility() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter facility name");
            String facilityName = scanner.nextLine();
//            for (Map.Entry<Facility,Integer> facilityIntegerEntry: FacilityServiceImpl.facilityList.entrySet()) {
//                if (facilityName.equals(facilityIntegerEntry.getKey().getServiceName())){
//                    return facilityIntegerEntry.getKey();
//                }
//            }
            for (Facility facility : FacilityServiceImpl.facilityList.keySet()) {
                if (facilityName.equals(facility.getServiceName())) {
                    return facility;
                }
            }
            System.out.println("not found");
            return null;
        }
    }
//
//    public void showContractList() {
//        contactService.displayContractList();
//    }
//
//    public  void editContract(){
//        contactService.editContract();
//    }
//
//    public static  Queue<Booking> setToQueue() {
//        Scanner sc = new Scanner(System.in);
//        Queue<Booking> queue = new LinkedList<Booking>();
//        for (Booking booking : bookingList) {
//            queue.offer(booking);
//        }
//        return queue;
//    }

    @Override
    public void showBookingList() {
        for (Booking booking : bookingListAll) {
            System.out.println(booking);
        }
    }

    @Override
    public void showList() {

    }



}
