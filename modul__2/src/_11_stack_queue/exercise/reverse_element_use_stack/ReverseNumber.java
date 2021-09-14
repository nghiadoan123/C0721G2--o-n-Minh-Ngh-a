package _11_stack_queue.exercise.reverse_element_use_stack;

import _11_stack_queue.practice.stack_use_linkeled.MyGenericStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 2, 5, 6, 9, 7};
        //c2 dùng hàm
       // arr = reverse(arr);
        int[] arr1 = new int[6];
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }

//    public static int[] reverse(int[] arr){
//        Stack<Integer> stack = new Stack<>();
//        for (int i=0; i<arr.length;i++){
//            stack.push(arr[i]);
//        }
//        for (int i=0; i<arr.length;i++){
//            arr[i] = stack.pop();
//        }
//        return arr;
//    }
}
