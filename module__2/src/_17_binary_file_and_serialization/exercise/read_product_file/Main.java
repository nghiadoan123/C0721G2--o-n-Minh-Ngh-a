package _17_binary_file_and_serialization.exercise.read_product_file;

import _17_binary_file_and_serialization.practice.read_write_student_list_to_binary_file.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        boolean flag = true;
        while (flag) {
            System.out.println("Menu" + "\n"+ "1.add" + "\n"+ "2.show list" + "\n"+ "3.search" + "\n"  + "4.Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.displayProduct();
                    break;
                case 3:
                    productManager.search();
                    break;
                case 4:
                    System.out.println("exit");
                    flag = false;
                    break;
            }
        }
    }

}
