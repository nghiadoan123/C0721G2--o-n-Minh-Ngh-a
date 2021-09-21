package _14_thuat_toan_sap_xep.exercise;

import java.util.Arrays;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 0; i < array.length; i++){
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1];
                pos--;
            }
            System.out.println("inner" + Arrays.toString(array));
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i] + " ");
        }
    }
}
