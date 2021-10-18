package audit.controller;

import audit.service.SoTietKiemService;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        SoTietKiemService soTietKiemService = new SoTietKiemService();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean flagAdd = true;
        boolean flagAdd1 = true;

        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.thêm sổ \n" +
                    "2.xóa sổ\n" +
                    "3.xem danh sách sổ  \n" +
                    "4.Thoát");
            System.out.println("Chọn");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                   soTietKiemService.add();
                    break;
                case 2:
                    soTietKiemService.delete();
                    break;
                case 3:
                    soTietKiemService.display();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }
}
