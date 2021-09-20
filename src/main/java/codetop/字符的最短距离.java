package codetop;

/**
 * Title: 字符的最短距离
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-10
 */
public class 字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        int pre = -10000;
        int len = s.length();
        int[] res = new int[len];


        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                pre = i;
            }
            res[i] = i - pre;
        }

        pre = 10000;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pre = i;
            }
            res[i] = Math.min(pre - i, res[i]);
        }

        return res;
    }
}
