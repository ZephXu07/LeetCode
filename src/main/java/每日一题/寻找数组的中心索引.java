package 每日一题;

import java.util.Arrays;

/**
 * Title: 寻找数组的中心索引
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-28
 */
public class 寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        System.out.println(Arrays.toString(preSum));
        int left;
        int right;
        for (int i = 0; i < len; i++) {
            left = preSum[i];
            right = preSum[len] - preSum[i + 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {-1,-1,-1,0,1,1};
        int[] nums = {1, 2, 3};
        寻找数组的中心索引 res = new 寻找数组的中心索引();
        System.out.println(res.pivotIndex(nums));
    }
}
