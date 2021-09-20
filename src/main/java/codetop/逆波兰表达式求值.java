package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 逆波兰表达式求值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        /*
            数字压栈
            符号直接弹出两个数字
            进行相应计算后再压栈
         */
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            char c = s.charAt(0);
            /*
                长度为 1 表示单符号
             */
            if (s.length() == 1 && (c <= 47 || c >= 58)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+' :
                        stack.push(a + b);
                        break;
                    case '-' :
                        stack.push(b - a);
                        break;
                    case '*' :
                        stack.push(a * b);
                        break;
                    case '/' :
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
                continue;
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
