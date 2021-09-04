package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class PushElementInArray {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int arr[] = new int[n];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Display array:" + Arrays.toString(arr));
        int X;
        int index;
        System.out.println("input X value:");
        X = scanner.nextInt();
        System.out.println("input index need to push:");
        index = scanner.nextInt();
        int[] newArr = new int[arr.length + 1];
        if (index == -1 || index >= arr.length) {
            System.out.println("Can not add the element into array !");
        } else {
            for (int i = 0; i < newArr.length; i++) {
                if (index == i) {
                    newArr[i] = X;
                } else if (i < index) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i - 1]; // i>index
            }
        }
        System.out.println("New array : ");
        System.out.println(Arrays.toString(newArr));
    }
}
}
