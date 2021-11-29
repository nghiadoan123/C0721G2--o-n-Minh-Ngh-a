package electric_bill.untils;

import electric_bill.models.bill.Bill;

import java.io.*;
import java.util.TreeSet;

public class BillReadAndWriteToCSV {
    public static void writeListToCSV(TreeSet<Bill> billList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Bill bill : billList) {
                bufferedWriter.write(bill.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Bill> readListFromCSV(String pathFile) {
        TreeSet<Bill> billList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    Bill bill = new Bill(array[0],array[1],Integer.parseInt(array[2]),Double.parseDouble(array[3]));
                   // bill.setTotal();
                    billList.add(bill);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }catch (Exception e){

            }
        }
        return billList;
    }
}
