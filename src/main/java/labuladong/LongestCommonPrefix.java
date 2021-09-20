package labuladong;

/**
 * Title: labuladong.LongestCommonPrefix
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-20
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        String s = l.longestCommonPrefix(strs);
        System.out.println(s);
        System.out.println("----------------------");
        String[] strs1 = {"dog","racecar","car"};
        s = l.longestCommonPrefix(strs1);
        System.out.println(s);
        System.out.println("----------------------");
        String[] strs2 = {"",""};
        s = l.longestCommonPrefix(strs2);
        System.out.println("结果：" + s);
        System.out.println("----------------------");
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
