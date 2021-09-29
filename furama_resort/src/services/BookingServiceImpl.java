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
    public static final String FILE_PATH = "/Users/nguyenmaithi/Documents/NGHĨA/C0721G2--o-n-Minh-Ngh-a/furama_resort/src/data/booking.csv";
    public static TreeSet<Booking> bookingList = BookingReadAndWriteFileToCSV.readListBookingFromCSV(FILE_PATH);
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    ContractServiceImpl contactService = new ContractServiceImpl();

    @Override
    public void add() {
        customerService.showList();
        facilityService.showList();
        System.out.println("Enter customer ID");
        String customerId = scanner.nextLine();
        Customer customer = CustomerServiceImpl.setCustomer(customerId);
        if (customer == null){
            System.out.println("please register customer first");
            return;
        }
        System.out.println("Enter service name");
        String serviceName = scanner.nextLine();
        Facility facility = FacilityServiceImpl.setFacilityTime(serviceName);
        if (facility == null){
            System.out.println("please register facility first");
            return;
        }
        System.out.println("Enter bookingID");
        String bookingID = scanner.nextLine();
        System.out.println("enter checkin day");
        String checkinDay = PersonInput.inputCheckInOut();
        System.out.println("enter checkout day");
        String checkoutDay = PersonInput.inputCheckInOut();
        Booking booking = new Booking(bookingID,checkinDay,checkoutDay,customer,facility);
        bookingList.add(booking);
        BookingReadAndWriteFileToCSV.writeListBookingToCSV(bookingList,FILE_PATH,false);
        showBookingList();
    }

    public void showContractList() {
        contactService.displayContractList();
    }

    public  void editContract(){
        contactService.editContract();
    }

    public void createContract(){
        Scanner sc = new Scanner(System.in);
        Queue<Booking> queue = new LinkedList<Booking>();
        for (Booking booking : bookingList) {
            queue.offer(booking);
        }

        for (Booking booking: bookingList) {
            System.out.println(queue.poll());
            contactService.createContract();
        }
    }
    @Override
    public void showBookingList() {
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    @Override
    public void showList() {

    }

    @Override
    public void search() {

    }

    @Override
    public void delete() {

    }


}
