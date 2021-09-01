package introduction_to_Java.exercise;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        double rate = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("mời nhập vào số tiền USD");
        usd = sc.nextDouble();
        double qui_doi = usd*rate;
        System.out.println("giá trị vnd là:" + qui_doi);
    }
}
