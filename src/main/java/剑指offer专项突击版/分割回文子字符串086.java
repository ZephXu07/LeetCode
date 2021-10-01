package 剑指offer专项突击版;

import 每日一题.分割回文串;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 分割回文子字符串086
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 分割回文子字符串086 {
    public String[][] partition(String s) {
        if (s.length() == 1) {
            return new String[][]{{s}};
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (i == j) ||
                        ((dp[i + 1][j - 1] || j - i == 1) && s.charAt(i) == s.charAt(j));
            }
        }
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> level = new LinkedList<>();
        backtrack(0, s, level, dp, res);
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i).toArray(new String[0]);
        }
        return ans;
    }


    private void backtrack (int inx, String s, LinkedList<String> level, boolean[][] dp, List<List<String>> res) {
        if (inx == s.length()) {
            res.add(new LinkedList<>(level));
            return;
        }

        for (int j = inx; j < s.length(); j++) {
            if (dp[inx][j]) {
                level.addLast(s.substring(inx, j + 1));
                backtrack(j + 1, s, level, dp, res);
                level.removeLast();
            }
        }

    }


    public static void main(String[] args) {
        分割回文子字符串086 res = new 分割回文子字符串086();
        System.out.println(Arrays.deepToString(res.partition("bbbbbbbbbbbbbbbb")));
    }
}
