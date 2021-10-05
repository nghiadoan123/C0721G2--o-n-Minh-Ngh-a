package phuong_tien_giao_thong.controller;

import java.util.Scanner;

public class LopDieuKhien {
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean flagVehicle = true;
        boolean flagAdd = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Thêm mới phương tiện\n" +
                    "2.. Hiện thị phương tiện\n" +
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
                                break;
                            case 2:
                                System.out.println("2.Thêm ôtô.");
                                break;
                            case 3:
                                System.out.println("3.Thêm  xe máy");
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
                                break;
                            case 2:
                                System.out.println("2.Hiện thị ôtô.");
                                break;
                            case 3:
                                System.out.println("3.Hiện  xe máy");
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
