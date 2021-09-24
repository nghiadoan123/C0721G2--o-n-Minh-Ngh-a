package services;

import models.service.booking.Booking;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    public static Set<Booking> bookingList = new TreeSet<>();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    ContractServiceImpl contactService = new ContractServiceImpl();

    @Override
    public void add() {

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
