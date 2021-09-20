package 每日一题;

/**
 * Title: 搜索旋转排序数组二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-07
 */
public class 搜索旋转排序数组二 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        搜索旋转排序数组二 search = new 搜索旋转排序数组二();
        int[] nums = {1};
        int target = 0;
        System.out.println(search.search(nums, target));
    }
}
