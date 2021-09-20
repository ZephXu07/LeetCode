package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 和为s的连续正数序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        int sum;
        List<int[]> res = new LinkedList<>();
        while (left < right) {
            sum = (left + right) * (right - left + 1) / 2;
            if (sum < target) {
                right ++;
            } else if (sum > target) {
                left ++;
            } else if (sum == target) {
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

    public static void main(String[] args) {
        和为s的连续正数序列 res = new 和为s的连续正数序列();
        int[][] ints = res.findContinuousSequence(9);
        for (int[] i:ints) {
            System.out.println(Arrays.toString(i));
        }
    }
}
