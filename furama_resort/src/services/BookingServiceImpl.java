package services;

import models.person.Customer;
import models.service.Facility;
import models.service.booking.Booking;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner scanner = new Scanner(System.in);
    public static Set<Booking> bookingList = new TreeSet<>();
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

        System.out.println("Enter bookingID");
        String bookingID = scanner.nextLine();
        System.out.println("emter checkin day");
        String checkinDay = Input.inputCheckInOut();
        System.out.println("emter checkout day");
        String checkoutDay = Input.inputCheckInOut();
        Booking booking = new Booking(bookingID,checkinDay,checkoutDay,customer,facility);
        bookingList.add(booking);
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
