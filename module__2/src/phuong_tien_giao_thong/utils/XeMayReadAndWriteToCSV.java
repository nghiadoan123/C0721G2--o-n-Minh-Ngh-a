package phuong_tien_giao_thong.utils;

import phuong_tien_giao_thong.models.phuong_tien.Oto;
import phuong_tien_giao_thong.models.phuong_tien.XeMay;

import java.io.*;
import java.util.TreeSet;

public class XeMayReadAndWriteToCSV {
    public static void writeListToCSV(TreeSet<XeMay> xeMays, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (XeMay xeMay : xeMays) {
                bufferedWriter.write(xeMay.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<XeMay> readListFromCSV(String pathFile) {
        TreeSet<XeMay> xeMayList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    XeMay xeMay = new XeMay(array[0],array[1],array[2],array[3],Double.parseDouble(array[4]));
                    xeMayList.add(xeMay);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }catch (Exception e){

            }
        }
        return xeMayList;
    }
}
