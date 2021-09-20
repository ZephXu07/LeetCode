package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 最长有效括号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 最长有效括号 {

    public int longestValidParentheses(String s) {
        /*
        https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
         */

        /*
            长度小于2的不可能构成有效括号对，0
         */
        if (null == s || s.length() < 2) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        /*
            对于坐标为 i 的字符串，其与前方构成的连续的有效括号对的长度
         */

        int max = 0;
        /*
            最长
         */

        for (int i = 1; i < len; i++) {
            /*
                下标为 0 的无论是 (，)都无法构成，忽略
             */
            if (s.charAt(i) == ')') {
                /*
                    只有为 ')' 时才可以判断
                 */
                if (s.charAt(i - 1) == '(') {
                    /*
                        如果前一个字符是 '('，肯定无法和除了靠后一位的 ')' 以外的 ')' 配对
                     */
                    dp[i] = 2;
                    /*
                        就目前这两个位置而言，已经配对成功了，有效括号是2
                     */
                    if (i - 2 >= 0){
                        //如果当前下标大于等于2，表示前面至少还有2个字符，
                        // 再加上他们的有效括号长度，而他们的长度怎样不需要关心，因为我们在前面已经求出来了
                        dp[i] += dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    /*
                        如果不是'('，则是')'，
                        还有另外的情况，但需要前面的括号有效长度不为0，
                        因为为0表示前面已经没有有效的括号对，此处的')'作废，
                        例如")))))"，此处直接失败，
                        而如果是 "))())"，")(())"等情况，其前面一个字符的有效括号长度不为0时则可以再进讨论
                     */
                    if (i - 1 - dp[i - 1] >= 0
                            && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        /*
                            当前一个')'对应的有效括号长度存在，
                            且对应的'('前面还有字符时，且此字符为'('时，可考虑与')'配对
                         */

                        dp[i] = dp[i - 1] + 2;
                        /*
                            配对则长度 + 2
                         */
                        if (i - 2 - dp[i - 1] >= 0) {
                            /*
                            此时同理，如果前面还有字符，
                            则可以再加上他们的有效括号长度，而他们的长度怎样不需要关心，因为我们在前面已经求出来了
                             */
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }

            max = Math.max(max, dp[i]);
            /*
                每一位找到最大的
             */
        }

        return max;

    }

    public int longestValidParenthesesStack(String s) {
        /*
            https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
         */
        int max = 0;
        /*
            最长有效括号的长度
         */
        Deque<Integer> stack = new LinkedList<>();
        /*
            栈，栈底为未匹配的最后一个右括号
         */
        stack.push(-1);
        /*
            虚拟的未匹配的最后一个右括号，
            以防为“()”将字符串将栈清空后无法计算有效括号长度，
            它代表着前面的符号都是不能匹配的，在此之后的都是可以匹配的
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                /*
                    左括号“(”直接压入栈
                 */
                stack.push(i);
            } else {
                /*
                    遇到右括号“)”直接将栈顶元素弹出
                        如果栈顶为“(”左括号，直接匹配，
                            如果栈不为空，说明前面有不能匹配的左或右括号，
                                此时直接计算这一段的有效的括号的长度，
                                为当前下标减去前面一个未匹配的左或右括号的下标即可计算当前这一段的有效长度
                            如果栈为空，说明前面的已经匹配完了，
                                前面已经消去所有的有效的括号了，
                                此处的右括号“)”是最后一个未匹配的，重新回到开始的情况
                        如果栈顶为“)”，说明前面已经乱了，没有有效的括号来匹配了
                            直接弹出前面的右括号的下标，放入新的右括号的下标，
                            再重新开始此种流程的判断
                 */
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }


    public int longestValidParenthesesTwoPointer(String s) {
        /*
        https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
         */
        int left = 0;
        /*
            左括号数目
         */
        int right = 0;
        /*
            右括号数目
         */
        int max = 0;
        /*
            最长有效括号长度
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            /*
               1. 从左往右遍历
                如果左大于右，可以继续，此时直到右等于左时，
                    表明这一段都是有效的括号长度，右的数目的两倍就是长度
                如果右大于左，则这一段在左往右遍历的时候不满足，
                    直接抛弃置为0

             2.   从右往左遍历
                如果右大于左，继续，直到左右相等，同理左数量两倍则是这一段的长度
                如果左大于右，则这一段在左往右遍历时候不满足，置为0重新开始

              3.例子
                0123456789
                (((()))(()
                这个例子在左往右中因为算法只能计算出2，但是在右往左的算法中可以计算出6

                0123456789
                ()()()))))
                在左往右中计算出6，但在右往左中无法计算

              4.综上所述，左右两次遍历即可求出最大长度
             */
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (right > left) {
                right = 0;
                left = 0;
            }
        }
        right = 0;
        left = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                right = 0;
                left = 0;
            }
        }
        return max;
    }
}
