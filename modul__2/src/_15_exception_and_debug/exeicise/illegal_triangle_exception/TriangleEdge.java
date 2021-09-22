package _15_exception_and_debug.exeicise.illegal_triangle_exception;

import java.util.Scanner;

public class TriangleEdge {
    public static void triangleEdge() throws IllegalTriangleException {
        System.out.println("nhập vào 3 cạnh của tam giác:");
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        boolean flagA = true;
        while (flagA) {
            flagA = false;
            try {
                System.out.println("cạnh a =");
                a = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("đã nhập vào chuỗi");
                System.out.println("mời nhập lại số");
                flagA = true;
            }
        }
        System.out.println("cạnh b =");
        int b = 0;
        boolean flagB = true;
        while (flagB) {
            flagB = false;
            try {
                b = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                flagB = true;
                System.out.println("đã nhập vào chuỗi");
                System.out.println("mời nhập lại số");
            }
        }
        System.out.println("cạnh c =");
        int c = 0;
        boolean flagC = true;
        while (flagC) {
            flagC = false;
            try {
                c = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                flagC = true;
                System.out.println("đã nhập vào chuỗi");
                System.out.println("mời nhập lại số");
            }
        }

        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("một trong ba canh a b c là số âm");
        } else if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("ba canh a b c không hợp lệ");
        }
    }
}
