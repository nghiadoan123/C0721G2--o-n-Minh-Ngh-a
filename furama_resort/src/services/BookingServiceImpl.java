package services;

import models.Booking;
import models.Contract;

import java.util.*;

public class BookingServiceImpl {
    private static Set<Booking> bookingList = new TreeSet<>();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    ContactServiceImpl contactService = new ContactServiceImpl();

    static {
        bookingList.add(new Booking(1, 25, 28, 1, "villa1", "normal"));
        bookingList.add(new Booking(2, 22, 30, 2, "room1", "vip"));
        bookingList.add(new Booking(3, 20, 30, 3, "house1", "normal"));
    }

    public void addNewBooking() {
        System.out.println("display customer list:");
        customerService.displayCustomer();
        System.out.println("display Facility list:");
        facilityService.addFacility();
        showBookingList();

        Scanner sc = new Scanner(System.in);
        System.out.println("input booking id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("input booking start day:");
        int startDay = sc.nextInt();
        System.out.println("input booking stop day:");
        int stopDay = sc.nextInt();
        System.out.println("input customer id:");
        int customerId = sc.nextInt();
        System.out.println("input service name:");
        String serviceName = sc.next();
        System.out.println("input service type:");
        String serviceType = sc.next();

        Booking booking = new Booking(id, startDay, stopDay, customerId, serviceName, serviceType);
        bookingList.add(booking);
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

    public void displayListContract(){
        contactService.displayContractList();
    }

    public  void editContract(){
        contactService.editContract();
    }


    public void showBookingList() {
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

}
