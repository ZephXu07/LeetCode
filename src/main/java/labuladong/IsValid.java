package labuladong;

import java.util.Stack;

/**
 * Title: labuladong.IsValid
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-18
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (!stack.empty() && leftSide(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private char leftSide(char left) {
        if (left == ')') {
            return '(';
        } else if (left == ']') {
            return '[';
        } else {
            return '{';
        }
    }


    public static void main(String[] args) {
        String s = "()";
        IsValid isValid = new IsValid();
        boolean res = isValid.isValid(s);
        System.out.println(res);

    }
}
