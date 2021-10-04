package utils;

import models.person.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerReadAndWriteFileToCSV {
    public static void writeListCustomerToCSV(List<Customer> customerList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> readListCustomerFromCSV(String pathFile) {
        LinkedList<Customer> customerList = new LinkedList<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
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

    public static List<Customer> readDataFromFile(String file) {
        List<Customer> customer = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            customer = (List<Customer>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("File is empty");
        }
        return customer;
    }

    public static void writeToFile(List<Customer> customers, String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
