package codetop;

import java.util.*;

/**
 * Title: 删除无效的括号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 删除无效的括号 {
    public List<String> removeInvalidParentheses(String s) {
        int leftExtra = 0;
        int rightExtra = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                /*
                    左括号，自然加一
                 */
                leftExtra++;
            } else if (c == ')') {
                /*
                    右括号，先看看是否有多余的左括号可以匹配
                    否则这个右括号是多余的
                 */
                if (leftExtra > 0) {
                    leftExtra--;
                } else {
                    rightExtra++;
                }
            }
        }

        StringBuilder path = new StringBuilder();
        Set<String> memo = new HashSet<>();
        dfs(0, 0, leftExtra, rightExtra, path, 0, s, memo);
        return new ArrayList<>(memo);
    }


    private void dfs (int leftNow, int rightNow, int leftExtra, int rightExtra,
                      StringBuilder path, int inx, String s, Set<String> memo) {
        if (inx == s.length()) {
            if (leftExtra == 0 && rightExtra == 0) {
                /*
                    leftExtra
                    rightExtra
                    表示多余的左右括号，所以此处两个等于 0 时有效的左右括号数量会是一样的
                    因为多余的是根据一样的字符串计算出来的，剩下的当然是有效的
                 */
                memo.add(path.toString());

            }
            return;
        }

        char c = s.charAt(inx);
        /*
            删除当前字符
         */
        if (c == '(' && leftExtra > 0) {
            /*
                当前是左括号，且还有多余的可删除左括号，可以尝试删除
             */
            dfs(leftNow, rightNow, leftExtra - 1, rightExtra, path, inx + 1, s, memo);
        } else if (c == ')' && rightExtra > 0) {
            /*
                当前是右括号，且还有多余的可删除右括号，可以尝试删除
             */
            dfs(leftNow, rightNow, leftExtra, rightExtra - 1, path, inx + 1, s, memo);
        }

        /*
            保留当前字符
         */
        path.append(c);
        if (c != '(' && c != ')') {
            /*
                不是左右括号，
                只能是小写字母，跳过
             */
            dfs(leftNow, rightNow, leftExtra, rightExtra, path, inx + 1, s, memo);
        } else if (c == '(') {
            /*
                有效的左括号加一
             */
            dfs(leftNow + 1, rightNow, leftExtra, rightExtra, path, inx + 1, s, memo);
        } else if (rightNow < leftNow) {
            /*
                此刻此字符只能是右括号
                且当前有效的右括号严格小于有效的左括号才可以尝试保留右括号
                因为从左往右遍历的，有效的左括号数量永远大于等于有效的右括号数量
                所以有效的右括号加一
                否则不需要尝试，剪枝
             */
            dfs(leftNow, rightNow + 1, leftExtra, rightExtra, path, inx + 1, s, memo);
        }
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        删除无效的括号 res = new 删除无效的括号();
//        res.removeInvalidParentheses("()())()").forEach(System.out::println);
        res.removeInvalidParentheses(")(").forEach(System.out::println);
    }
}
