package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumInArray {
    public static void main(String[] args) {
        int size;
        System.out.println("input array size:");
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int arr[] = new int[size];
        System.out.println("input array element:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Aray is:");
        System.out.println(Arrays.toString(arr));
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("min of array is:" + min + " " + "at index:" + index);
    }
}
