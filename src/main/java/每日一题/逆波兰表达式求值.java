package 每日一题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Title: 逆波兰表达式求值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            char c = s.charAt(0);
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



    public static void main(String[] args) {
        逆波兰表达式求值 sum = new 逆波兰表达式求值();
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(sum.evalRPN(tokens));
        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(sum.evalRPN(tokens));
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sum.evalRPN(tokens));
        tokens = new String[]{"3","-4","+"};
        System.out.println(sum.evalRPN(tokens));
    }
}
