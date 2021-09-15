package _11_stack_queue.exercise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalinDrome {
    public static void main(String[] args) {
        System.out.println("nhập một chuỗi");
        Scanner sc = new Scanner(System.in);
        if (checkPalinDrome(sc.nextLine())) {
            System.out.println("string is palindrome");
        } else {
            System.out.println("string is not palindrome");
        }

    }

    public static boolean checkPalinDrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        String toLowerCase = str.toLowerCase();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            queue.offer(toLowerCase.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            stack.push(toLowerCase.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != queue.remove()) {
                flag = false;
            }
        }
        return flag;
    }
}
