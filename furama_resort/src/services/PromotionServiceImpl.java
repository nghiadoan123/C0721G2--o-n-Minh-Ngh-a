package services;

import models.service.booking.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class PromotionServiceImpl {
    public static Scanner scanner = new Scanner(System.in);
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    protected SimpleDateFormat getYear = new SimpleDateFormat("yyyy");
    protected static TreeSet<Booking> bookingTreeSet = BookingServiceImpl.bookingList;


    public void displayCustomerUseService() {
        System.out.println("Enter year used services !");
        String year = scanner.nextLine();
        for (Booking e : bookingTreeSet) {
            try {
                Date date = dateFormat.parse(e.getCheckIn());
                String year1 = getYear.format(date);
                if (year.contains(year1)) {
                    System.out.println(e);
                }
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }
}
