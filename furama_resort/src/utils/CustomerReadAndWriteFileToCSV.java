package utils;

import models.person.Customer;

import java.io.*;
import java.util.LinkedList;

public class CustomerReadAndWriteFileToCSV {
    public static void writeListCustomerToCSV(LinkedList<Customer> customerList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getInfoCustomerToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> getListCustomerFromCSV(String pathFile) {
        LinkedList<Customer> customerList = new LinkedList<>();
        File file = new File(pathFile);
        System.out.println(file.length());
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = new String[9];
                System.out.println(bufferedReader.readLine());
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    String id = array[0];
                    String name = array[1];
                    String dayOfBirth = array[2];
                    String gender = array[3];
                    int identityNumber = Integer.parseInt(array[4]);
                    String phoneNumber = array[5];
                    String email = array[6];
                    String typeOfCustomer = array[7];
                    String address = array[8];


                    Customer customer = new Customer(id, name, dayOfBirth, gender, identityNumber, phoneNumber, email, typeOfCustomer, address);
                    customerList.add(customer);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return customerList;
    }
}
