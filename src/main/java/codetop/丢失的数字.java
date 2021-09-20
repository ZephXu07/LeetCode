package codetop;

/**
 * Title: 丢失的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-28
 */
public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
