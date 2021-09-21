package _15_exception_and_debug.exeicise.illegal_triangle_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            triangleEdge();
        } catch (IllegalTriangleException e) {
           //c2 System.out.println(e.getErr());
        }
    }

    public static void triangleEdge() throws IllegalTriangleException {
        try {
            System.out.println("nhập vào 3 cạnh của tam giác:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("cạnh a =");
            int a = scanner.nextInt();
            System.out.println("cạnh b =");
            int b = scanner.nextInt();
            System.out.println("cạnh c =");
            int c = scanner.nextInt();
            if (a<0 || b<0|| c<0 ||a+b<c || b+c<a || a+c<b){
                //c1
                throw new IllegalTriangleException();
                //c2
                //throw new IllegalTriangleException("ba cạnh nhập vào không đúng");
            }
        }catch (Exception e){
            System.err.print("ba canh nhập vào không hợp lệ");
        }
    }
}
