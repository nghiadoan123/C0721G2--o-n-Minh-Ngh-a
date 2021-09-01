package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);// khai báo đối tượng scanner

        System.out.println("Enter width:");// Nhập chiều rộng
        width = scanner.nextFloat();

        System.out.println("Enter height:"); // nhập chiều dài
        height = scanner.nextFloat();
        float area = width * height;

        System.out.println("Area is:" + area);

    }
}
