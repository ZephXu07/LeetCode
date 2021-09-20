package codetop;

/**
 * Title: 寻找峰值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        寻找峰值 res = new 寻找峰值();
//        int[] nums = {1,2,1,3,5,6,4};
        int[] nums = {1,2,3,1};
        System.out.println(res.findPeakElement(nums));
    }
}
