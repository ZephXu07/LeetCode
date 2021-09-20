package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 反转每对括号间的子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-26
 */
public class 反转每对括号间的子串 {
    public String reverseParenthesesOn2(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseParenthesesOn(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int len = s.length();
        int[] next = new int[len];

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int tmp = stack.pop();
                next[i] = tmp;
                next[tmp] = i;
            }
        }


        StringBuilder sb = new StringBuilder();
        int dir = 1;
        for (int i = 0; i < len; i += dir) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = next[i];
                dir = - dir;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        反转每对括号间的子串 res = new 反转每对括号间的子串();
//        String s = "(abcd)";
//        String s = "(u(love)i)";
//        String s = "(ed(et(oc))el)";
//        String s = "(a(bc(def)g)h)";
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(res.reverseParenthesesOn2(s));
        System.out.println(res.reverseParenthesesOn(s));
    }
}
