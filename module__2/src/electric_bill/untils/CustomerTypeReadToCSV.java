package electric_bill.untils;

import electric_bill.models.customer.TypeCustomer;
import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;

import java.io.*;
import java.util.ArrayList;

public class CustomerTypeReadToCSV {

    public static ArrayList<TypeCustomer> readFromCSV(String pathFile) {
        ArrayList<TypeCustomer> typeCustomers = new ArrayList<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    TypeCustomer typeCustomer = new TypeCustomer(array[0],array[1]);
                    typeCustomers.add(typeCustomer);
                }
                bufferedReader.close();
            }catch (EOFException e){

            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }catch (Exception e){

            }
        }
        return typeCustomers;
    }
}
