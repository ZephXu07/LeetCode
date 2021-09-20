package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 和为s的连续正数序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        int sum;
        List<int[]> res = new LinkedList<>();
        while (left < right) {
            sum = (left + right) * (right - left + 1) / 2;
            /*
                等差数列求和
             */
            if (sum < target) {
                right ++;
                /*
                    [left, right] 还不够，right++
                 */
            } else if (sum > target) {
                /*
                    [left, right] 太大了，left++，范围缩小
                 */
                left ++;
            } else {
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
                left ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
