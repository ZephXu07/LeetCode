package 每日一题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 基本计算器二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class 基本计算器二 {
    public int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Queue<Character> queue = new LinkedList<>();
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i);
            if (tmp != ' ') {
                queue.offer(tmp);
            }
        }
        queue.offer(' ');
        return compute(queue);
    }

    private int compute(Queue<Character> queue) {
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        char c;
        while (!queue.isEmpty()) {
            c = queue.poll();
            if (c == '(') {
                num = compute(queue);
            } else if (Character.isDigit(c)){
                num = 10 * num + c - '0';
            } else {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
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
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
