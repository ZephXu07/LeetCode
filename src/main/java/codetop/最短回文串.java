package codetop;

/**
 * Title: 最短回文串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-12
 */
public class 最短回文串 {
    public String shortestPalindrome(String s) {
        /*
            s 逆序得到 r
            n = s + # + r 是回文串，但不一定是最短的
            找到 t =  n [0, len-1] 的最长公共前后缀的长度
            即 t = s[0, len - 1] 与 r [rLen - len, rLen - 1] 相同，
            这部分则作为回文中心
            而 r[0, rlen - len -1] 这部分则是需要添加在 s 前面
            所以有 r[0, rlen - len -1] + s
                                      = r[rLen - len,rLen-1] + s[len, Slen - 1]
         */
        StringBuilder reverse = new StringBuilder(s).reverse();
        String merge = s + "#" + reverse;
        int len = getNext(merge);
        return reverse.substring(0, s.length() - len - 1) + s;
    }

    private int getNext (String s) {
        int len = s.length();
        int[] next = new int[len];
        int j = -1;
        next[0] = j;
        /*
            在next数组中记录的起始位置是-1
            下面的操作都是 j + 1 使不会溢出范围

            next[i] 表示 [0, i]之前最长相等的前后缀长度（其实就是j）
            在 j != -1 时有 [0, j-1] 与 [i - j + 1, i] 相等

            所以初始化 next[0] = j
         */
        for (int i = 1; i < len; i++) {
            /*
                next[0] 已经确定为 - 1
                从下标 1 开始
                i 指向后缀，j 指向前缀
             */
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                /*
                    [0, j] 与 [i - 1 - j, i - 1] 相等
                    s[j+1] != s[i] ，所以前后缀不相同了，向前回溯
                    前面有 [0, j] == [i - 1 - j, i - 1] || j == -1 没有相等的前后缀
                    此处是 s[j + 1] 所以从 j 开始即可

                    当 s[i] == s[j+1] 了，即前后缀末尾相同了即可继续新的前后缀计算最长长度
                    或者全部回溯完， j == -1，没有找到相同的前缀后缀，结束
                 */
                j = next[j];
                /*
                    回溯到包括前一个字符的字符串的最长相等前后缀长度
                 */
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                /*
                    当 s[i] == s[j+1] 了，
                    找到相同的前后缀
                    更新新的前后缀计算最长长度
                 */
                j++;
            }

            next[i] = j;
            /*
                记录 i（包括i）之前最长相等的前后缀长度（其实就是j）
             */

        }
        return next[len - 1];
        /*
            要求的是 [0, len-1] 的最长前后缀长度，返回一个即可
         */

    }

    public static void main(String[] args) {
        最短回文串 res = new 最短回文串();
//        System.out.println(res.shortestPalindrome("aacecaaa"));
//        System.out.println(res.shortestPalindrome("abcd"));
        System.out.println(res.shortestPalindrome("ABADFBA"));
    }
}
