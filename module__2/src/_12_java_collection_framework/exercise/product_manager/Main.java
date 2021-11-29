package _12_java_collection_framework.exercise.product_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Add\n" +
                    "2.show\n" +
                    "3.delete\n" +
                    "4.edit\n" +
                    "5.search\n" +
                    "6.sort up price\n" +
                    "7.sort down price\n" +
                    "8.Exit");
            System.out.println("Chọn");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    managerProduct.addProduct();
                    break;
                case 2:
                    managerProduct.showProduct();
                    // hiện thị
                    break;
                case 3:
                    // xóa
                    managerProduct.deleteProduct();
                    break;
                case 4:
                    // edit
                    managerProduct.editProduct();
                    break;
                case 5:
                    // search
                    managerProduct.searchProduct();
                    break;
                case 6:
                    // sort up
                    managerProduct.sortUpPrice();
                    break;
                case 7:
                    // sort down
                    managerProduct.sortDownPrice();
                    break;
                case 8:
                    flag = false;
            }
        }

    }
}
