package electric_bill.untils;

import electric_bill.models.customer.ForengCustomer;
import electric_bill.models.customer.Customer;
import electric_bill.models.customer.VietNamCustomer;

import java.io.*;
import java.util.TreeSet;

public class CustomerReadAndWriteToCSV {

    public static void writeListToCSV(TreeSet<Customer> customerList, String pathFile, boolean append) {
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

    public static TreeSet<Customer> readListFromCSV(String pathFile) {
        TreeSet<Customer> customerList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    if (array.length == 3){
                        ForengCustomer forengCustomer = new ForengCustomer(array[0],array[1],array[2]);
                        customerList.add(forengCustomer);
                    }else if (array.length == 4){
                        VietNamCustomer vietNamCustomer = new VietNamCustomer(array[0],array[1],array[2],Double.parseDouble(array[3]));
                        customerList.add(vietNamCustomer);
                    }

                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return customerList;
    }
}
