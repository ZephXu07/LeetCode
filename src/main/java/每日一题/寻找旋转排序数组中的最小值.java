package 每日一题;

/**
 * Title: 寻找旋转排序数组中的最小值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0;
        int right = len - 1;
        int mid = left;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {11,13,15,17};
        寻找旋转排序数组中的最小值 minVal = new 寻找旋转排序数组中的最小值();
        System.out.println(minVal.findMin(nums));
    }
}
