package 二分查找;

/**
 * Title: 左边界二分查找
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-04
 */
public class 左边界二分查找 {
    public int binarySearchLeft (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        左边界二分查找 res = new 左边界二分查找();
    }
}
