package 杂类;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Title: 移除无效的括号1249
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-29
 */
public class 移除无效的括号1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }



    public static void main(String[] args) {
        移除无效的括号1249 res = new 移除无效的括号1249();
//        System.out.println(res.minRemoveToMakeValid("lee(t(c)o)de)"));
//        System.out.println("ab(c)d".equals(res.minRemoveToMakeValid("a)b(c)d")));
//        System.out.println("".equals(res.minRemoveToMakeValid( "))((")));
//        System.out.println("a(b(c)d)".equals(res.minRemoveToMakeValid( "(a(b(c)d)")));
//        System.out.println(res.minRemoveToMakeValid( "())()((("));
        System.out.println(res.minRemoveToMakeValid( "hqu(u))))((((((pv()))((()ug)((q)))((((j)oq()jbl((f"));
    }
}
