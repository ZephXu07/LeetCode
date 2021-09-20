package 每日一题;

/**
 * Title: 最大连续1的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-15
 */
public class 最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
//        int left = 0;
//        int right = 0;
//        int len = nums.length;
//        int res = 0;
//        while (right < len) {
//            if (right > 0 && nums[right - 1] == 0 && nums[right] == 1) {
//                left = right;
//            }
//            if (nums[right] == 1) {
//                res = Math.max(right - left + 1, res);
//            }
//            right++;
//        }
//        return res;

        int res = 0, count = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        最大连续1的个数 res = new 最大连续1的个数();
        System.out.println(res.findMaxConsecutiveOnes(nums));
    }
}
