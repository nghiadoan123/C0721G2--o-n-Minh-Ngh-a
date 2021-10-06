package phuong_tien_giao_thong.utils;

import phuong_tien_giao_thong.models.phuong_tien.XeMay;
import phuong_tien_giao_thong.models.phuong_tien.XeTai;

import java.io.*;
import java.util.TreeSet;

public class XeTaiReadAndWriteToCSV {
    public static void writeListToCSV(TreeSet<XeTai> xeTais, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (XeTai xeTai : xeTais) {
                bufferedWriter.write(xeTai.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<XeTai> readListFromCSV(String pathFile) {
        TreeSet<XeTai> xeTaiList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    XeTai xeTai = new XeTai(array[0],array[1],array[2],array[3],Double.parseDouble(array[4]));
                    xeTaiList.add(xeTai);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return xeTaiList;
    }
}
