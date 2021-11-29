package _02_loop_in_java.practice;

import java.util.Scanner;

public class CheckIsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        // cách 1
        if (number < 2){
            System.out.println(number + " is not a prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
//        // cách 2
//        if (number < 2){
//            System.out.println(number + " is not a prime");
//        }else {
//            int i = 2;
//            boolean check = true;
//            while (i < number) {
//                if (number % i == 0) {
//                    check = false;
//                    break;
//                }
//                i++;
//            }
//            if (check)
//                System.out.println(number + " is a prime");
//            else
//                System.out.println(number + " is not a prime");
//        }
    }
}
