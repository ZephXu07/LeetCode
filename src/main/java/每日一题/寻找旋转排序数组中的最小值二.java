package 每日一题;

/**
 * Title: 寻找旋转排序数组中的最小值二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-09
 */
public class 寻找旋转排序数组中的最小值二 {
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
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,5};
//        int[] nums = {2,2,2,0,1};
        int[] nums = {3,3,1,3};
        寻找旋转排序数组中的最小值二 minVal = new 寻找旋转排序数组中的最小值二();
        System.out.println(minVal.findMin(nums));
    }

}
