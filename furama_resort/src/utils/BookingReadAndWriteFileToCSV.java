package utils;

import models.person.Customer;
import models.person.Employee;
import models.service.booking.Booking;
import models.service.booking.CheckInComparator;
import models.service.facility.Facility;
import models.service.villa.Villa;
import services.CustomerServiceImpl;
import services.FacilityServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class BookingReadAndWriteFileToCSV {
    public static void writeListBookingToCSV(TreeSet<Booking> bookingList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookingList) {
                bufferedWriter.write(booking.getInfoBookingToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static TreeSet<Booking> readListBookingFromCSV(String pathFile) {
//        TreeSet<Booking> bookingList = new TreeSet<>();
//        File file = new File(pathFile);
//        if (file.length() > 0) {
//            try {
//                FileReader fileReader = new FileReader(file);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//                String line = "";
//                String[] array = null;
//                while ((line = bufferedReader.readLine()) != null) {
//                    array = line.split(",");
//                    String bookingId = array[0];
//                    String checkIn = array[1];
//                    String checkOut = array[2];
//
//                    String idNumber = array[3];
//                    Customer customer = new Customer();
//                    for (Customer customers : CustomerServiceImpl.customerList) {
//                        if (customer.getId() ==idNumber) {
//                            customer = customers;
//                        }
//                    }
//                    String serviceName = array[4];
//                    Facility facility = null;
//                    for (Map.Entry<Facility,Integer> entry : FacilityServiceImpl.facilityList.entrySet()) {
//                        if (entry.getKey().getServiceName().equals(serviceName)){
//                            facility = entry.getKey();
//                        }
//                    }
//                    Booking booking = new Booking(bookingId, checkIn, checkOut, customer, facility);
//                    bookingList.add(booking);
//                }
//                bufferedReader.close();
//            }catch (EOFException e){
//
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Lỗi đọc file");
//            }
//        }
//        return bookingList;
//    }

    public static TreeSet<Booking> readDataFromFile(String bookingFile) {
        TreeSet<Booking> bookingTreeSet = new TreeSet<>();
        try {
            FileInputStream fis = new FileInputStream(bookingFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookingTreeSet = (TreeSet<Booking>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("File is empty");
        }
        return bookingTreeSet;
    }

    public static void writeToFile(TreeSet<Booking> bookings, String bookingFile) {
        try {
            FileOutputStream fos = new FileOutputStream(bookingFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookings);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

