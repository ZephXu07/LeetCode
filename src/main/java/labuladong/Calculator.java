package labuladong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Title: labuladong.Calculator
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-21
 */
public class Calculator {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        if (null == s || s.length() == 0) {
            return 0;
        }
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (' ' != c) {
                queue.offer(c);
            }
        }
        queue.offer(' ');
        return helper(queue);
    }


    private int helper(Queue<Character> queue){
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        char c;
        while (!queue.isEmpty()) {
            c = queue.poll();
            if (c == '(') {
                num = helper(queue);
            }else if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else {
                switch (sign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
                if (c == ')') {
                    break;
                }
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(1 + 1-6*2/3)";
        Calculator c = new Calculator();
        int ans = c.calculate(s);
        System.out.println(ans);

    }
}
