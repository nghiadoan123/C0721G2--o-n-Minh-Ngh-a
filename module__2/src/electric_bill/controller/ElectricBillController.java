package electric_bill.controller;

import electric_bill.service.BillService;
import electric_bill.service.CustomerSerrvice;
import phuong_tien_giao_thong.services.OtoService;
import phuong_tien_giao_thong.services.XeMayService;
import phuong_tien_giao_thong.services.XeTaiService;

import java.util.Scanner;

public class ElectricBillController {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        CustomerSerrvice customerSerrvice = new CustomerSerrvice();
        BillService billService = new BillService();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean flagAdd = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Thêm mới khách hàng\n" +
                    "2.Hiện thị thông tin khách hàng\n" +
                    "3.Tìm kiếm khách hàng \n" +
                    "4.Thêm mới hóa đơn \n" +
                    "5. Chỉnh sửa hóa đơn \n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn \n" +
                    "7.Thoát");
            System.out.println("Chọn");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
//                    do {
//                        System.out.println("Chọn chức năng\n" +
//                                "1. Thêm khách hàng vn.\n" +
//                                "2. Thêm khách hàng nn.\n" +
//                                "3.Return main menu\n" );
//                        int chooseCase1 = Integer.parseInt(scanner.nextLine());
//                        switch (chooseCase1){
//                            case 1:
//                                System.out.println("1. Thêm KHVN.");
//                                customerSerrvice.add();
//                                break;
//                            case 2:
//                                System.out.println("2.Thêm KHNN.");
//                                customerSerrvice.add();
//                                break;
//                            case 3:
//                                // exit
//                                System.out.println("4.Return main menu");
//                                flagAdd = false;
//                                break;
//                        }
//                    }while (flagAdd);
                    customerSerrvice.add();
                    break;
                case 2:
                    customerSerrvice.display();
                    break;
                case 3:
                    customerSerrvice.searchCustomer();
                    break;
                case 4:
                    billService.add();
                    break;
                case 5:
                    billService.edit();
                    break;
                case 6:
                    billService.display();
                    break;
                case 7:

                    flag = false;
                    break;
            }
        }
    }
}
