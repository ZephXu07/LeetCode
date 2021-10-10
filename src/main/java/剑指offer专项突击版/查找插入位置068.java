package 剑指offer专项突击版;

/**
 * Title: 查找插入位置068
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-10
 */
public class 查找插入位置068 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
