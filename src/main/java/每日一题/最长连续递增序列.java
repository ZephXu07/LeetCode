package 每日一题;

/**
 * Title: 最长连续递增序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-24
 */
public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] <= nums[i - 1]) {
                start = i;
            }
            res = Math.max(i - start + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        最长连续递增序列 res = new 最长连续递增序列();
        System.out.println(res.findLengthOfLCIS(nums));
    }
}
