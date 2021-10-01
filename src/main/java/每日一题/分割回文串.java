package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 分割回文串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-07
 */
public class 分割回文串 {
    private List<List<String>> res;
    private List<String> level;
    private int len;
    private boolean[][] pal;
    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        level = new LinkedList<>();
        len = s.length();
        pal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pal[i], true);
        }
        for (int i = len - 1; i>= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                pal[i][j] = (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]);
            }
        }
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int inx) {
        if (inx == len) {
            res.add(new LinkedList<>(level));
            return;
        }
        for (int j = inx; j < len; j++) {
            if (pal[inx][j]) {
                level.add(s.substring(inx, j + 1));
                backtrack(s, j + 1);
                level.remove(level.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        分割回文串 res = new 分割回文串();
        String s = "bbbbbbbbbbbbbbbb";
        List<List<String>> lists = res.partition(s);
        for (List<String> l:lists) {
            for (String str : l) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }


}
