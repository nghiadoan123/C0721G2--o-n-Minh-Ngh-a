package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumDiagonalOfSquareMatrix {
    static int sumDiagonalofMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter square of matrix:");
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("your matrix size is:" + size + "X" + size);
        System.out.println("input element in matrix:" + size + "X" + size);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Display matrix:" + Arrays.deepToString(matrix));
        System.out.println("sum diagonal of square matrix is: " + sumDiagonalofMatrix(matrix));
    }
}
