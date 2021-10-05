package phuong_tien_giao_thong.utils;

import phuong_tien_giao_thong.models.phuong_tien.HangSanXuat;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeSet;

public class HangSanXuatReadFileToCSV {

    public static ArrayList<HangSanXuat> readHangSanXuatFromCSV(String pathFile) {
        ArrayList<HangSanXuat> hangSanXuats = new ArrayList<>();
        File file = new File(pathFile);
        if (file.length() > 0) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                String[] array = null;
                while ((line = bufferedReader.readLine()) != null) {
                    array = line.split(",");
                   HangSanXuat hangSanXuat = new HangSanXuat(array[0],array[1],array[2]);
                   hangSanXuats.add(hangSanXuat);
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
        return hangSanXuats;
    }
}
