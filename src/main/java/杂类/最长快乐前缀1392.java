package 杂类;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 最长快乐前缀1392
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-20
 */
public class 最长快乐前缀1392 {
    public String longestPrefix(String s) {
        int len = s.length();
        int j = -1;
        int[] next = new int[len];
        next[0] = j;

        for (int i = 1; i < len; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return s.substring(0, next[len - 1] + 1);
    }

    public static void main(String[] args) {
        最长快乐前缀1392 res = new 最长快乐前缀1392();
        System.out.println(res.longestPrefix("aaaaa"));
        System.out.println(res.longestPrefix("level"));
        System.out.println(res.longestPrefix("ababab"));
        System.out.println(res.longestPrefix("leetcodeleet"));
        System.out.println(res.longestPrefix("a"));
    }
}
