package 每日一题;

import java.util.Arrays;

/**
 * Title: 数组拆分一
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-16
 */
public class 数组拆分一 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
