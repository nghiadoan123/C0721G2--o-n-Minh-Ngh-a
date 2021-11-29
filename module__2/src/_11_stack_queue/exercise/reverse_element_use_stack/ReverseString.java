package _11_stack_queue.exercise.reverse_element_use_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = " hello dlrow";
        reverse(str);
    }

    public static void reverse(String str) {
        Stack<Character> stack = new Stack<>();
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }

}
