package codetop;

/**
 * Title: 长度最小的子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        /*
            滑动窗口
         */
        int min = Integer.MAX_VALUE;
        /*
            长度
         */
        int left = 0;
        /*
            左边界
         */
        int right = 0;
        /*
            右边界
         */
        int sum = 0;
        /*
            左、右边界（包含）之间的和
         */
        int len = nums.length;
        while (right < len) {
            /*
                还没遍历完
             */
            sum += nums[right];
            /*
                新增右边界的值
             */
            while (sum >= target) {
                /*
                    如果和大于等于目标的和，重新计算长度，再移除左边界的值，
                    继续移除得到最小长度，如果不能满足大于等于目标，则继续添加新边界
                 */
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
                /*
                    左边界递增
                 */
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
