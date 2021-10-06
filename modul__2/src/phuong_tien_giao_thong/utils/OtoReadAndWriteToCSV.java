package phuong_tien_giao_thong.utils;

import phuong_tien_giao_thong.models.phuong_tien.Oto;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class OtoReadAndWriteToCSV {

    public static void writeListToCSV(TreeSet<Oto> otos, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Oto oto : otos) {
                bufferedWriter.write(oto.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Oto> readListFromCSV(String pathFile) {
        TreeSet<Oto> otoList = new TreeSet<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                    Oto oto = new Oto(array[0],array[1],array[2],array[3],Integer.parseInt(array[4]),array[5]);
                    otoList.add(oto);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }
        }
        return otoList;
    }
}
