package 每日一题;

/**
 * Title: 有效的括号字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-12
 */
public class 有效的括号字符串 {
//    public boolean checkValidString(String s) {
//        int len = s.length();
//        boolean[][] dp = new boolean[len][len];
//
//        dp[0][0] = s.charAt(0) == '*';
//
//        for (int i = 1; i < len; i++) {
//            char pre = s.charAt(i - 1);
//            char cur = s.charAt(i);
//            dp[i][i] = cur == '*';
//
//            if ((pre == '(' || pre == '*') &&
//                    (cur == ')' || cur == '*')) {
//                dp[i - 1][i] = true;
//            }
//        }
//        /*
//            枚举长度为 1 和 长度为 2 的
//            *
//            ()      (*      *)      ()
//         */
//
//        for (int i = len - 3; i >= 0; i--) {
//            /*
//                枚举长度 3以上的
//                因为转移方程是两段向中心压缩的，i ,j 取值特别
//             */
//            char pre = s.charAt(i);
//            for (int j = i + 2; j < len; j++) {
//                char cur = s.charAt(j);
//
//                if (((pre == '(') || (pre == '*')) &&
//                        ((cur == ')' || cur == '*'))) {
//                    /*
//                        前后相同看中间
//                     */
//                    dp[i][j] = dp[i + 1][j - 1];
//                }
//                /*
//                    如果 [i,j] true则跳过下面的
//                    否则将字符串分两段
//                    直到找到合适的切分方法使 [i,j] true 或
//                    全部遍历不能切分
//                 */
//                for (int k = i; k < j && !dp[i][j]; k++) {
//                    dp[i][j] = dp[i][k] && dp[k + 1][j];
//                }
//            }
//        }
//        return dp[0][len - 1];
//    }

//    public boolean checkValidString(String s) {
//        int left = 0;
//        int right = 0;
//        /*
//            多余左括号的可能范围
//         */
//        char[] arr = s.toCharArray();
//        for (char c : arr) {
//            if (c == '(') {
//                left++;
//                right++;
//                /*
//                    出现左括号，多余左括号的左右边界增加
//                 */
//            } else if (c == '*') {
//                /*
//                    ( 相当左括号，左右边界均添加 [left+1,right+1]
//                    null 相当于空，不变 [left,right]
//                    ) 相当于右括号，多余左括号的右边界先减一，
//                    而左边界要看情况，如果大于0，则可以减一，[left-1,right-1]
//                    如果等于0，即多余左括号的数量范围是0起始的，此时不需要减一，
//                    因为我们表示的是多余左括号的边界，小于 0 左括号都不多余了，此刻也不能减一
//                    即此处我们不会将其当做是一个右括号来匹配多余左括号，
//                    [left,right-1]
//                    而其实如果 0 == left < right，[left,right-1]
//                    如果 0 == left == right，此刻 right -- = -1
//                    我们会在下面进行判断，如果 right < 0，表示没有多余的左括号，还缺失
//                    由于我们是从左往右遍历的，根本无法补充正确的左括号，所以直接返回
//
//                    例子
//                    (***)
//                    (   [1,1]
//                    (*  [0,2] *为左括号则 right++=2,*为 null则不变，*为右括号则抵消，left--=0
//                    (** [0,3] *为左括号则 right++=3,*为 null则不变，*为右括号则抵消，而抵消的情况是第一个* 表示为null，left--=0
//                    (*** [0,4) *为左括号则 right++=4,*为 null则不变，*为右括号则抵消，而抵消的情况是第一、二个* 表示为null，left--=0
//                    (***) [0,3] 右括号抵消了一个，right--=3
//                 */
//                if (left > 0) {
//                    left--;
//                }
//                right++;
//            } else {
//                if (left > 0) {
//                    left--;
//                }
//                right--;
//                /*
//                    右括号，使得多余左括号的边界均需要缩减
//                    参考 * 的当做 ) 的解释
//                 */
//            }
//
//            if (right < 0) {
//                return false;
//                /*
//                    如果 right < 0，表示没有多余的左括号，还缺失
//                    由于我们是从左往右遍历的，根本无法补充正确的左括号，所以直接返回
//                 */
//            }
//        }
//
//        return left == 0;
//        /*
//            多余左括号的边界，如果此时不等于 0
//            表示遍历结束即使我们将 * 号处理为 ) 右括号仍无法减少左括号的数量
//            这是错误的括号匹配
//         */
//    }

    public boolean checkValidString(String s) {
        int left = 0;
        int star = 0;
        /*
            从左到右遍历
            保证 “)” 都有对应的 “(”
            left 记录左括号数量
            star 记录右括号数量
            遇到 “(” left ++
            “(” left--
            当 left < 0表示左括号用完了
            此时 * 号补充由括号，
            如果 start 也为负数，
            说明无论怎么样当前遍历的由括号少了与之对应的左括号

         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            } else {
                star++;
            }

            if (left < 0) {
                star--;
                left++;
            }

            if (star < 0) {
                return false;
            }
        }

        /*
            右边同理
         */
        int right = 0;
        star = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                right--;
            } else {
                star++;
            }

            if (right < 0) {
                star--;
                right++;
            }

            if (star < 0) {
                return false;
            }
        }

        return true;
    }

}
