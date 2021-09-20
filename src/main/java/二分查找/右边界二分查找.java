package 二分查找;

/**
 * Title: 右边界二分查找
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-04
 */
public class 右边界二分查找 {
    public int binarySearchRight (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        右边界二分查找 res = new 右边界二分查找();
    }
}
