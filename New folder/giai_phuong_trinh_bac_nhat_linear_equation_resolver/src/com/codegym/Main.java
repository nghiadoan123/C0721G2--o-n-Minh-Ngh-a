package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Linear equation resolver");
        System.out.println("Given a equation at 'a*x+b=c',please enter constants:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("a:");
        double a = scanner.nextDouble();

        System.out.println("b:");
        double b = scanner.nextDouble();

        System.out.println("c:");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);// % f! bỏ giá trị answer thé chỗ f và hiển thị
            // Equation pass with x = 1.000000!
            System.out.println(answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
