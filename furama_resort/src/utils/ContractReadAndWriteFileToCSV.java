package utils;

import models.person.Customer;
import models.service.booking.Booking;
import models.service.contract.Contract;
import models.service.facility.Facility;
import services.CustomerServiceImpl;
import services.FacilityServiceImpl;

import java.io.*;
import java.util.Map;
import java.util.TreeSet;

public class ContractReadAndWriteFileToCSV {
    public static void writeListBookingToCSV(TreeSet<Contract> contractList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract : contractList) {
                bufferedWriter.write(contract.getInfoContractToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Contract> readListBookingFromCSV(String pathFile) {
        TreeSet<Contract> contractList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    int contractNumber = Integer.parseInt(array[0]);
                    int bookingNumber = Integer.parseInt(array[1]);
                    double deposit = Double.parseDouble(array[2]);
                    double totalPayment = Double.parseDouble(array[3]);

                    int identityNumber = Integer.parseInt(array[4]);
                    Customer customer1 = new Customer();
                    for (Customer customer : CustomerServiceImpl.customerList) {
                        if (customer.getIdentityNumber() == identityNumber) {
                            customer1 = customer;
                        }
                    }

                    Contract contract = new Contract(contractNumber, bookingNumber, deposit, totalPayment, customer1);
                    contractList.add(contract);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return contractList;
    }
}
