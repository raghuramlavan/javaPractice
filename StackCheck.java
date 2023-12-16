package javaPractice;

import java.lang.String;
import java.util.Stack;

class StackCheck {
    private static boolean checkParantisis(String paran) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < paran.length(); i++) {
            if (paran.charAt(i) == ')') {
                if (stack.size() == 0 || stack.pop() != '(')
                    return false;

            } else {
                stack.push(paran.charAt(i));
            }
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(checkParantisis("(())()()"));

    }
}