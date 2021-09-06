package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
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
        int index = 1;
        System.out.println("Nhập số nguyên k cần xóa: ");
        int X = scanner.nextInt();
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == X) {
                index += i;
                count++;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("vị trí xuất hiện của X :" + index);
        } else {
            System.out.printf("không có %d trong mảng", X);
        }
        // c1
        int[] newarr = new int[arr.length - count];
        for (int i = 0; i < arr.length; i++) {
            if (X != arr[i]) {
                for (int j = 0; j < newarr.length; j++) {
                    // kiểm tra đã có gí trị của mảng mới chưa nếu chưa thì thêm vào
                    if (newarr[j] == 0) {
                        newarr[j] = arr[i];
                        break;
                    }
                }
            }
        }
        // c2 duyet song song mang
//        for (int i = 0, j = 0 ; i < arr.length || j < newarr.length   ;i++){
//            if (X != arr[i]){
//                newarr[j] = arr[i];
//                j++;
//            }
//        }
        System.out.println("Display new arr : ");
        System.out.println(Arrays.toString(newarr));
        // c3
//        for (int i = index; i < arr.length - 1; i++) {
//            arr[i] = arr[i + 1];
//        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
