package 每日一题;

import java.util.Arrays;

/**
 * Title: 数组中最大数对和的最小值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-20
 */
public class 数组中最大数对和的最小值 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int pair = nums.length / 2;
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < pair; i++) {
            res = Math.max(res, nums[i] + nums[len - 1 - i]);
        }
        return res;
    }
}
