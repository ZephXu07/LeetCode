package codetop;

/**
 * Title: 调整数组顺序使奇数位于偶数前面
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
