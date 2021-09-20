package 每日一题;

import java.util.Arrays;

/**
 * Title: 分发饼干
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-25
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gInx = g.length - 1;
        int sInx = s.length - 1;
        while (gInx >= 0 && sInx >= 0) {
            if (s[sInx] >= g[gInx]) {
                count ++;
                gInx --;
                sInx --;
            } else {
                gInx --;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        分发饼干 res = new 分发饼干();
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(res.findContentChildren(g, s));
    }
}
