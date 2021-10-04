package week261;

/**
 * Title: 含特定字母的最小子序列5893
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 含特定字母的最小子序列5893 {
    private String res;
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        res = "";
        StringBuilder builder = new StringBuilder();
        dfs(s, k, letter, repetition, builder, 0, 0);
        return res;
    }

    private void dfs (String s, int k, char letter, int repetition, StringBuilder builder, int count, int inx) {

        if (k == 0) {
            if (count < repetition) {
                return;
            }
            String tmp = builder.toString();
            if ("".equals(res)) {
                res = tmp;
            } else if (res.compareTo(tmp) > 0){
                res = tmp;
            }
            return;
        }
        if (inx >= s.length()) {
            return;
        }
        if (k >= repetition - count) {
            dfs(s, k, letter, repetition, builder, count, inx + 1);
        }
        char c = s.charAt(inx);
        if (c == letter) {
            count++;
        }
        builder.append(c);
        dfs(s, k - 1, letter, repetition, builder, count, inx + 1);
        builder.deleteCharAt(builder.length() - 1);
    }

    public static void main(String[] args) {
        含特定字母的最小子序列5893 res = new 含特定字母的最小子序列5893();
//        System.out.println(res.smallestSubsequence("leet", 3, 'e', 1));
//        System.out.println(res.smallestSubsequence("leetcode", 4, 'e', 2));
//        System.out.println(res.smallestSubsequence("bb", 2, 'b', 2));
        System.out.println(res.smallestSubsequence("wuynymkihfdcbabefiiymnoyyytywzy",
                16, 'y', 4));
    }

}
