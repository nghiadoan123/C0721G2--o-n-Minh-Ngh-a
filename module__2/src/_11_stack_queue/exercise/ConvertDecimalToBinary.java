package _11_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        System.out.println("input number: ");
        Scanner sc = new Scanner(System.in);
        System.out.println(convertDecimalToBinary(sc.nextInt()));
    }

    public static String convertDecimalToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        if (num == 0) {
            return 0 + "";
        } else if (num < 0) {
            throw new IndexOutOfBoundsException("input <0");
        } else {
            while (num != 0) {
                int residual = num % 2;
                stack.push(residual);
                num /= 2;
            }
            String str = "";
            while (!stack.empty()) {
                str += stack.pop();
            }
            return str;
        }

    }
}
