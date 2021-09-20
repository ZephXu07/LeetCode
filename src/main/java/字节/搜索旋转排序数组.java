package 字节;

/**
 * Title: 搜索旋转排序数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-24
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        搜索旋转排序数组 res = new 搜索旋转排序数组();
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(res.search(nums, target));
    }
}
