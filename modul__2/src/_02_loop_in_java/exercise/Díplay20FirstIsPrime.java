package _02_loop_in_java.exercise;

import java.util.Scanner;

public class Díplay20FirstIsPrime {
    public static void main(String[] args) {
        int count = 0;
        boolean flag;
        int n = 2;
        String result = "";
        System.out.print("display 20 first prime:\n");
        while (count < 20) {
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

