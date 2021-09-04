package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxValueInArray2D {
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
        int max = array2D[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (max < array2D[i][j]) {
                    max = array2D[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.printf("max in array is: %d at index i= %d and j = %d", max, x, y);
    }
}
