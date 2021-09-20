package 字节;

/**
 * Title: 长度最小子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 长度最小子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int res = len;
        int sum = 0;
        boolean flag = false;
        while (right < len) {
            if (sum + nums[right] >= target) {
                sum += nums[right];
                flag = true;
                while (sum  >= target && left <= right) {
                    res = Math.min((right - left + 1), res);
                    sum -= nums[left];
                    left++;
                }
            } else {
                sum += nums[right];
             }
            right++;
        }
        if (sum >= target) {
            res = Math.min(right - left, res);
        }
        while (sum >= target &&  left < len) {
            if (sum - nums[left] >= target) {
                res = Math.min((right - left), res);
                sum -= nums[left];
            }
            left++;
        }
        return flag ? res : 0;
    }

    public static void main(String[] args) {
        长度最小子数组 res = new 长度最小子数组();
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;
//        int[] nums = {1,1,1,1,1,1,1,1};
//        int target = 11;
        int[] nums = {1,2,3,4,5};
        int target = 15;
        System.out.println(res.minSubArrayLen(target, nums));
    }

}
