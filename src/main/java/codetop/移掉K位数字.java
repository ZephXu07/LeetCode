package codetop;

import labuladong.Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 移掉K位数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-06
 */
public class 移掉K位数字 {
//    public String removeKdigits(String num, int k) {
//        int len = num.length();
//        if (len <= k) {
//            return "0";
//        }
//        Deque<Character> stack = new LinkedList<>();
//        int inx = 0;
//        if (len >= 2 && num.charAt(1) == '0') {
//            inx = 2;
//            k--;
//            while (inx < len && num.charAt(inx) == '0') {
//                inx++;
//            }
//            if (inx == len) {
//                return "0";
//            }
//        }
//
//        while (inx < len && k > 0) {
//            while (!stack.isEmpty() && stack.peek() > num.charAt(inx) && k > 0) {
//                stack.pop();
//                k--;
//            }
//            stack.push(num.charAt(inx));
//            inx++;
//        }
//        StringBuilder res = new StringBuilder();
//        if (k == 0) {
//            while (!stack.isEmpty()) {
//                res.append(stack.pop());
//            }
//            res.reverse();
//            if (inx < len) {
//                res.append(num.substring(inx));
//            }
//        } else if (inx == len && k > 0) {
//            if (stack.size() <= k) {
//                res.append("0");
//            } else {
//                while (!stack.isEmpty()) {
//                    if (k > 0) {
//                        stack.pop();
//                        k--;
//                    } else {
//                        res.append(stack.pop());
//                    }
//                }
//                res.reverse();
//            }
//
//        } else {
//            return "0";
//        }
//        inx = 0;
//        while (inx < res.length() - 1 && res.charAt(inx) == '0') {
//            inx++;
//        }
//        return res.substring(inx);
//    }

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        /*
            126a25
            126b25
            如果 a > b，即 126a25 > 126b25
            因为是要更小的数字，于是抛弃 a
            于是使用单调栈，栈底到栈顶单调递减

         */
        for (int i = 0; i < len; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            /*
                移除的数字不够 k 位
                继续从后面移除直到 k
             */
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean flag = true;
        /*
            比较是否前导0
            是则忽略跳过
            否则则添加
         */
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (flag && digit == '0') {
                continue;
            }
            flag = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
        /*
            可能为空，特例判断一下
         */
    }

    public static void main(String[] args) {

        移掉K位数字 res = new 移掉K位数字();
        System.out.println(res.removeKdigits("1432219", 3) + "\t1219");
        System.out.println(res.removeKdigits("10200", 1) + "\t200");
        System.out.println(res.removeKdigits("10", 2) + "\t0");
        System.out.println(res.removeKdigits("10", 1) + "\t0");
        System.out.println(res.removeKdigits("112", 1) + "\t11");
        System.out.println(res.removeKdigits("5337", 2) + "\t33");
        System.out.println(res.removeKdigits("12345", 2) + "\t123");
        System.out.println(res.removeKdigits("1234567890", 9) + "\t0");
        System.out.println(res.removeKdigits("10001", 4) + "\t0");
    }
}
