package phuong_tien_giao_thong.services;

import phuong_tien_giao_thong.models.phuong_tien.Oto;
import phuong_tien_giao_thong.models.phuong_tien.PhuongTien;
import phuong_tien_giao_thong.models.phuong_tien.XeTai;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class OtoService implements Service{
    public static Scanner scanner = new Scanner(System.in);
    public static TreeSet<PhuongTien> OtoList = new TreeSet<>();

    public static String chonKieuXe() {

        while (true) {
            System.out.println("chon kieu xe" + "\n" + "1.KIEU_DU_LICH" + "\n" + "2.KIEU_XE_KHACH" + "\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Oto.KIEU_DU_LICH;
                case "2":
                    return Oto.KIEU_XE_KHACH;
                default:
                    System.out.println("in put again");
                    break;
            }
        }
    }



    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {

    }

    @Override
    public void remove() {

    }
}
