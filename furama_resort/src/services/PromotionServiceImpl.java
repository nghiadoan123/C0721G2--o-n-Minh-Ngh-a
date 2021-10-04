package services;

import models.service.booking.Booking;
import models.service.voucher.Voucher;
import java.time.LocalDate;
import java.util.*;

public class PromotionServiceImpl {
    public static Scanner scanner = new Scanner(System.in);
    protected static Stack<Booking> bookingListMonth = new Stack<>();
    protected static Queue<Voucher> voucherQueue = new ArrayDeque<>();

    public void displayCustomerUseService() {
        System.out.println("Enter year used services !");
        System.out.println(BookingServiceImpl.bookingListAll);
        int yearInput = 0;
            try {
                yearInput = Integer.parseInt(scanner.nextLine());
                for (Booking e : BookingServiceImpl.bookingListAll) {
                    if (yearInput == e.getCheckIn().getYear() + 1900) {
                        System.out.println(e);
                    } else {
                        System.out.println("not found");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("in valid input again");
            }
    }

    public static void createVouchers() {
        System.out.println("The number of customer have booked in this month : " + bookingListMonth.size() + " person");

        while (voucherQueue.size() < bookingListMonth.size()) {
            int choice = 0;
            boolean flag = true;
            while (flag) {
                flag = false;
                try {
                    System.out.println("1.Discount 50%" + "\n" + "2.Discount 20%" + "\n" + "3.Discount 10%" + "\n" + "Enter your choice");
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception exception) {
                    System.err.println("Invalid input !");
                    flag = true;
                }
            }
            switch (choice) {
                case 1:
                    voucherQueue.offer(new Voucher(Voucher.VOUCHER_10));
                    break;
                case 2:
                    voucherQueue.offer(new Voucher(Voucher.VOUCHER_20));
                    break;
                case 3:
                    voucherQueue.offer(new Voucher(Voucher.VOUCHER_50));
                    break;
                default:
                    System.err.println("Invalid input 1-3");
            }
        }
    }

    public void displayCustomerGetVoucher() {
        for (Booking e : BookingServiceImpl.bookingListAll) {
            if ((LocalDate.now().getYear() == e.getCheckIn().getYear() + 1900) && (LocalDate.now().getMonthValue() == e.getCheckIn().getMonth()+1)) {
               bookingListMonth.push(e);
            } else {
                System.out.println(e.getBookingId()+":"+"month:"+e.getCheckIn().getMonth()+",year:"+e.getCheckIn().getYear()+"not found");
                //return;
            }
        }
        createVouchers();
        for (Booking e : bookingListMonth) {
            System.out.println(e + " => have got: " + voucherQueue.poll() + " \n");
        }
    }

}
