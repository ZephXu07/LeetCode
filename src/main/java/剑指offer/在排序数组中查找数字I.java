package 剑指offer;/**
 * Title: 在排序数组中查找数字I
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int left = 0;
        int high = nums.length - 1;
        int count = 0;
        int mid;
        while (left <= high) {
            mid = left + (high - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                count ++;
                if ((mid - 1) >= left && nums[mid - 1] == target) {
                    int tmp = mid;

                    while (high >= --tmp && tmp >= left && nums[tmp] == target) {
                        count ++;
                    }
                }
                if ((mid + 1) <= high && nums[mid + 1] == target) {
                    int tmp = mid;
                    while (left <= ++tmp && tmp <= high && nums[tmp] == target) {
                        count ++;
                    }
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        在排序数组中查找数字I res = new 在排序数组中查找数字I();
        int[] nums = {3};
        System.out.println(res.search(nums, 0));
    }
}
