package _04_class_and_object_in_java.exercise.stop_watch;

import java.util.Scanner;

public class MainStopWatch {
    public static void main(String[] args) {
//        System.out.println("in put n");
//        Scanner sc = new Scanner(System.in);
//        do {
//            n = sc.nextInt();
//            if (n != 100000) {
//                System.out.println("input n=100000 and n>0");
//            }
//        } while (n != 100000);
        int n = 100000;
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += 1;
            arr[i] = arr[i] + sum;
        }
        StopWatch stopWatch = new StopWatch();
        SortArray sortArray = new SortArray();
        stopWatch.start();
        System.out.println("time of watch is running");
        // vì phương thức selectionsort là kiểu static nên gọi ko cần thông qua đối tượng mới
        // mà gọi trực tiếp từ lớp
        sortArray.selectionSort(arr, n);
        stopWatch.stop();
        // hàm printArray ko thuộc kiểu static nên phải gọi thông qua đối tượng stopWatch
        sortArray.printArray(arr, n);
        double elapsedTime = stopWatch.getElapsedtime();
        System.out.println();
        System.out.println("Elapsed time is: " + elapsedTime + " milisecond");
    }
}
