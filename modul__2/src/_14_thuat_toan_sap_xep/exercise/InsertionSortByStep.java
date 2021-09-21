package _14_thuat_toan_sap_xep.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public void insertionSort(int arr[]) {
        int x;
        int pos;

        // lap qua tat ca cac so
        for (int i = 1; i < arr.length; i++) {

            // chon mot gia tri de chen
            x = arr[i];

            // lua chon vi tri de chen
            pos = i;

            // kiem tra xem so lien truoc co lon hon gia tri duoc chen khong
            while (pos > 0 && arr[pos - 1] > x) {
                arr[pos] = arr[pos - 1];
                pos--;
                System.out.println("inner" + Arrays.toString(arr));
            }

            if (pos != i) {
                System.out.println(" Chen phan tu: " + x
                        + ", tai vi tri: " + pos);
                // chen phan tu tai vi tri chen
                arr[pos] = x;
                System.out.println("sau khi chèn" + Arrays.toString(arr));
            }

            System.out.println("Vong lap thu " + i);
            display(arr);
        }
    }

    public void display(int arr[]) {
        int i;
        System.out.print("[");

        // Duyet qua tat ca phan tu
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("]\n");
    }

    public static void main(String[] args) {
        // khoi tao mang arr
        int arr[] = { 6, 7, 0, 2, 8, 1, 3, 9, 4, 5 };

        InsertionSortByStep insertionSortByStep = new InsertionSortByStep();
        System.out.println("Mang du lieu dau vao: ");
        insertionSortByStep.display(arr);
        System.out.println("-----------------------------");
        insertionSortByStep.insertionSort(arr);
        System.out.println("-----------------------------");
        System.out.println("\nMang sau khi da sap xep: ");
        insertionSortByStep.display(arr);
    }
}
