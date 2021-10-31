package 杂类;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 字母大小写全排列784
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-31
 */
public class 字母大小写全排列784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        dfs(new StringBuilder(s), 0, res);
        return res;
    }

    private void dfs (StringBuilder str, int inx, List<String> res) {
        if (inx == str.length()) {
            res.add(str.toString());
            return;
        }
        char c = str.charAt(inx);
        if (Character.isLowerCase(c)) {
            dfs(str, inx + 1, res);

            str.setCharAt(inx, (char) (c - 'a' + 'A'));
            dfs(str, inx + 1, res);
            str.setCharAt(inx, c);
        } else if (Character.isUpperCase(c)){
            dfs(str, inx + 1, res);
            str.setCharAt(inx, (char) (c - 'A' + 'a'));
            dfs(str, inx + 1, res);
            str.setCharAt(inx, c);
        } else {
            dfs(str, inx + 1, res);
        }

    }

    public static void main(String[] args) {
        字母大小写全排列784 res = new 字母大小写全排列784();
        res.letterCasePermutation("a1b2").forEach(System.out::println);
    }
}
