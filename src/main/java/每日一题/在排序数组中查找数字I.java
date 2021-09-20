package 每日一题;

/**
 * Title: 在排序数组中查找数字I
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-16
 */
public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || len == 1 || nums[0] > target || nums[len - 1] < target) {
            if (len == 1 && nums[0] == target) {
                return 1;
            }
            return 0;
        }

        int left = leftEdge(nums, target);
        int right = rightEdge(nums, target);
        if (nums[left] != target && nums[right] != target) {
            return 0;
        }
        if (nums[left] != target || nums[right] != target) {
            return 1;
        }

        return right - left + 1;
    }

    private int leftEdge (int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else  {
                left = mid + 1;
            }
        }
        return left;
    }

    private int rightEdge (int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
