package cinemar.controller;

import cinemar.model.Cinema;
import cinemar.service.CinemaService;
import electric_bill.service.BillService;
import electric_bill.service.CustomerSerrvice;

import java.util.Scanner;

public class CinemaController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        CinemaService cinemaService = new CinemaService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.hiển thị \n" +
                    "2.thêm mới\n" +
                    "3.Xóa \n" +
                    "4.Thoát");
            System.out.println("Chọn");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                   cinemaService.display();
                    break;
                case 2:
                    cinemaService.add();
                    break;
                case 3:
                    cinemaService.delete();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }
}
