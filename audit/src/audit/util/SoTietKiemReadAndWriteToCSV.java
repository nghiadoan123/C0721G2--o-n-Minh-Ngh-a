package audit.util;

import audit.model.SoTietKiem;
import audit.model.SoTietKiemCoThoiHan;
import audit.model.SoTietKiemDaiHan;
import audit.model.SoTietKiemVoThoiHan;

import java.io.*;
import java.util.ArrayList;

public class SoTietKiemReadAndWriteToCSV {
    public static void writeListToCSV(ArrayList<SoTietKiem> soTietKiems, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SoTietKiem soTietKiem : soTietKiems) {
                bufferedWriter.write(soTietKiem.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){

        }
    }

    public static ArrayList<SoTietKiem> readListFromCSV(String pathFile) {
        ArrayList<SoTietKiem> soTietKiems = new ArrayList<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                   if (array.length == 6){
                       SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(array[0],array[1],array[2],array[3],Double.parseDouble(array[4]),Integer.parseInt(array[5]));
                   }else if (array.length ==7){
                       SoTietKiemCoThoiHan soTietKiemCoThoiHan = new SoTietKiemCoThoiHan(array[0],array[1],array[2],array[3],Integer.parseInt(array[4]),Double.parseDouble(array[5]),Integer.parseInt(array[6]));
                   }else {
                       SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(array[0],array[1],array[2],array[3],Integer.parseInt(array[4]),Double.parseDouble(array[5]),Integer.parseInt(array[6]),array[7]);
                   }
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi đọc file");
            }catch (Exception e){

            }
        }
        return soTietKiems;
    }
}
