package codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Title: 去除重复字母
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 去除重复字母 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();

        /*   维护一个计数器记录字符串中字符的数量
             因为输入为 ASCII 字符，大小 256 够用了
         */
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        char[] chars = s.toCharArray();
        for (char c :chars) {
            /*
                每遍历过一个字符，都将对应的计数减一
             */
            count[c]--;

            if (inStack[c]) {
                /*
                    存在栈中了，不需要再压
                 */
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                /*
                    单调栈
                    如果字符 c 的次数只出现一次，则不能弹出单调栈
                    否则则可以弹出单调栈，因为后面还同样的字符
                 */
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
                /*
                    因为后面还有，此处弹出栈，是否栈中的标记记为 false
                 */
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            /*
                栈是先进先出的，所以需要反转
             */
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        去除重复字母 res = new 去除重复字母();
        System.out.println(res.removeDuplicateLetters("bcabc"));
    }
}
