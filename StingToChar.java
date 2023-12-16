package javaPractice;

import java.util.ArrayList;
import java.util.Stack;

public class StingToChar {
    private ArrayList<String> result;

    private boolean isValid(String paran) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < paran.length(); i++) {
            if (paran.charAt(i) == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else {
                stack.push(paran.charAt(i));
            }
        }
        if (stack.size() == 0)
            return true;
        else {
            return false;
        }
    }

    private boolean validSofar(String paran) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < paran.length(); i++) {
            if (paran.charAt(i) == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else {
                stack.push(paran.charAt(i));
            }
        }
        return true;
    }

    private void checkP(String s, int n) {
        if (s.length() == n && this.isValid(s)) {
            this.result.add(s);
            return;
        }
        if (this.validSofar("(" + s)) {
            checkP("(" + s, n);
            checkP(s + "(", n);
        }
        if (this.validSofar(")" + s)) {
            checkP(")" + s, n);

        }
        if (this.validSofar(s + ")")) {
            checkP(s + ")", n);

        }

    }

    public static void main(String[] args) {
        StingToChar stc = new StingToChar();
        stc.result = new ArrayList<String>();
        String s = "()";
        stc.checkP(s, 6);
        System.out.println(stc.result);
    }
}
