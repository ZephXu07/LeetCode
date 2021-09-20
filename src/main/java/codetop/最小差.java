package codetop;

import java.util.Arrays;

/**
 * Title: 最小差
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 最小差 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int aInx = 0;
        int bInx = 0;
        long res = Integer.MAX_VALUE;
        while (aInx < a.length && bInx < b.length) {
            res = Math.min(res, Math.abs((long) a[aInx] - b[bInx]));
            if (a[aInx] <= b[bInx]) {
                aInx++;
            } else {
                bInx++;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        最小差 res = new 最小差();
        int[] a = {-2147483648,1};
        int[] b = {2147483647,0};
        System.out.println(res.smallestDifference(a, b));
    }
}
