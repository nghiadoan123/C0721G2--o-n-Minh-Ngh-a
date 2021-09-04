package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoArray {
    public static void main(String[] args) {
        int arrA[] = new int[5];
        int arrB[] = new int[6];
        Scanner sc = new Scanner(System.in);
        System.out.printf("in put %d element of array A:\n", arrA.length);
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = sc.nextInt();
        }
        System.out.printf("in put %d element of array B:\n", arrB.length);
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = sc.nextInt();
        }
        System.out.println("Array A : ");
        System.out.println(Arrays.toString(arrA));
        System.out.println("Array B : ");
        System.out.println(Arrays.toString(arrB));
        int arrC[] = new int[arrA.length + arrB.length];
        for (int i = 0; i < arrA.length; i++) {
            arrC[i] = arrA[i];
        }
        for (int i = 0; i < arrB.length; i++) {
            arrC[i + arrA.length] = arrB[i];
        }
        System.out.println("Array C : ");
        System.out.println(Arrays.toString(arrC));
    }
}
