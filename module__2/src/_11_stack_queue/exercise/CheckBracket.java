package _11_stack_queue.exercise;

import java.util.Stack;

public class CheckBracket {
    static boolean flag = true;

    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (s – c) ";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (str.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("well");
        } else {
            System.out.println("not well");
        }
    }

}



