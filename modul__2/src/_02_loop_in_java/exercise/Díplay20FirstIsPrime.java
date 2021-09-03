package _02_loop_in_java.exercise;

import java.util.Scanner;

public class Díplay20FirstIsPrime {
    public static void main(String[] args) {
        int number;
        int count = 0;
        boolean flag;
        int n = 2;
        String result = "";
        do {
            System.out.println("mời nhập vào số lượng số nguyên tố cần hiển thị <=20");
            Scanner sc = new Scanner(System.in);
            number = sc.nextInt();
        } while (number > 20);

        while (count < number) {
            flag = true;
            if (n < 2) {
                flag = false;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.print(result = n + " ");
                count++;
            }
            n++;
        }
    }
}

