package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfNumberInSpecifiedColum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập row:");
        int row = sc.nextInt();
        System.out.println("nhập col:");
        int col = sc.nextInt();
        System.out.println("nhập giá trị của mảng 2 chiều:");
        int[][] array2D = new int[row][col];
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.printf("arr2d at [i:%d,j:%d]:%d  \n", i, j, array2D[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(array2D));
        System.out.println("input specified colum you want to sum:");
        int input = sc.nextInt();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (input == -1 || input - 1 >= array2D[i].length) {
                    flag = true;
                    break;
                } else {
                    sum += array2D[i][input - 1];
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("can not sum this colum");
        } else {
            System.out.println("sum is:" + sum);
        }

    }
}
