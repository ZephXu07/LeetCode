package 每日一题;

/**
 * Title: 范围求和II598
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-07
 */
public class 范围求和II598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
