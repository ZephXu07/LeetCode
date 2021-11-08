package 杂类;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 含特定字母的最小子序列2030
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-08
 */
public class 含特定字母的最小子序列2030 {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int len = s.length();

        int [] suffixCnt = new int [len];
        /*
            s [i:len-1] 多少个 letter
         */
        int cnt = 0;
        for (int i = len - 1; i >= 0; i --) {
            if (s.charAt(i) == letter) {
                cnt ++;
            }
            suffixCnt[i] = cnt;
        }

        Deque<Character> stk = new LinkedList<>();
        int x = 0;
        /*
            letter在 栈 中已经出现的次数
         */
        for (int i = 0; i < len; i ++) {
            /*
                弹栈
                使栈底到栈顶单调递增
                栈非空 并且 栈元素长度 + 未遍历长度 >= 给定长度
                并且 栈顶字典序大于新元素
             */
            while (!stk.isEmpty()
                    && stk.size() + (len - i - 1) >= k
                    && s.charAt(i) < stk.peekLast()) {
                if (stk.peekLast() == letter) {
                    /*
                        更新栈中 letter 次数
                     */
                    x--;
                }
                if (x + suffixCnt[i] < repetition) {
                    /*
                        栈中 letter 次数和剩下的未遍历的 letter 次数小于 要求的次数
                        于是此次不弹出，再更新 x 栈中 letter 次数，前面的也不能弹出了
                        因为前面的字典序比 letter 还小，且要保持相对位置
                     */
                    x++;
                    break;
                }
                stk.pollLast();
                /*
                    弹出栈顶
                 */

            }
            /*
                如果长度则尝试压栈
                如果字符是 letter 或者 要求的长度-栈元素长度 比剩下的未压入的 letter 长度还长
                则可以压入新元素
             */
            if (stk.size() < k) {
                if (s.charAt(i) == letter
                        || (k - stk.size() > repetition - x)) {
                    stk.addLast(s.charAt(i));
                    if (s.charAt(i) == letter) {
                        ++ x;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            /*
                左往右遍历
             */
            res.append(stk.pollFirst());
        }
        return res.toString();
    }
}
