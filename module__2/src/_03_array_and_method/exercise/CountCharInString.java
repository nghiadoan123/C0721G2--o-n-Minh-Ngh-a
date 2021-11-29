package _03_array_and_method.exercise;

import java.util.Scanner;

public class CountCharInString {
    static int countCharinString(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("input your string");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println("input your char want to find");
        char c = sc.nextLine().charAt(0);
        System.out.println("char " + c + " display " + countCharinString(inputString, c) + " time in string");
    }
}
