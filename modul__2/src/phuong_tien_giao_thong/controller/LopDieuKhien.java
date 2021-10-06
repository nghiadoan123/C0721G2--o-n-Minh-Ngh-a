package phuong_tien_giao_thong.controller;

import phuong_tien_giao_thong.models.input.Input;
import phuong_tien_giao_thong.services.OtoService;
import phuong_tien_giao_thong.services.XeMayService;
import phuong_tien_giao_thong.services.XeTaiService;

import java.util.Scanner;

public class LopDieuKhien {

    public static void displayMainMenu() {
        OtoService otoService = new OtoService();
        XeMayService xeMayService = new XeMayService();
        XeTaiService xeTaiService = new XeTaiService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean flagVehicle = true;
        boolean flagRemove = true;
        boolean flagAdd = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Thêm mới phương tiện\n" +
                    "2.Hiện thị phương tiện\n" +
                    "3.Xóa phương tiện \n" +
                    "4.Thoát");
            System.out.println("Chọn");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // "1.Thêm mới phương tiện\n"
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1. Thêm xe tải.\n" +
                                "2.Thêm ôtô. \n" +
                                "3.Thêm  xe máy \n" +
                                "4.Return main menu\n" );
                        int chooseCase1 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase1){
                            case 1:
                                System.out.println("1. Thêm xe tải.");
                                xeTaiService.add();
                                break;
                            case 2:
                                System.out.println("2.Thêm ôtô.");
                                otoService.add();
                                break;
                            case 3:
                                System.out.println("3.Thêm  xe máy");
                                xeMayService.add();
                                break;
                            case 4:
                                // exit
                                System.out.println("4.Return main menu");
                                flagAdd = false;
                                break;
                        }
                    }while (flagAdd);
                    break;
                case 2:
                    // "2.. Hiện thị phương tiện\n"
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1. Hiện thị xe tải.\n" +
                                "2.Hiện thị ôtô. \n" +
                                "3.Hiện  xe máy \n" +
                                "4.Return main menu\n" );
                        int chooseCase1 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase1){
                            case 1:
                                System.out.println("1. Hiện thị xe tải.");
                                xeTaiService.display();
                                break;
                            case 2:
                                System.out.println("2.Hiện thị ôtô.");
                                otoService.display();
                                break;
                            case 3:
                                System.out.println("3.Hiện  xe máy");
                                xeMayService.display();
                                break;
                            case 4:
                                // exit
                                System.out.println("4.Return main menu");
                                flagVehicle = false;
                                break;
                        }
                    }while (flagVehicle);
                    break;
                case 3:
                    // "3.Xóa phương tiện \n"
                    do {
                        System.out.println("Chọn chức năng\n" +
                                "1.xóa xe tải.\n" +
                                "2.Xóa ôtô. \n" +
                                "3.xóa  xe máy \n" +
                                "4.Return main menu\n" );
                        int chooseCase1 = Integer.parseInt(scanner.nextLine());
                        switch (chooseCase1){
                            case 1:
                                System.out.println("1. xóa xe tải.");
                                xeTaiService.remove();
                                break;
                            case 2:
                                System.out.println("2.xóa ôtô.");
                                otoService.remove();
                                break;
                            case 3:
                                System.out.println("3.xóa xe máy");
                                xeMayService.remove();
                                break;
                            case 4:
                                // exit
                                System.out.println("4.Return main menu");
                                flagRemove = false;
                                break;
                        }
                    }while (flagRemove);
                    break;
                case 4:
                    // "4.Thoát"
                    flag = false;
                    break;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        displayMainMenu();
    }
}
