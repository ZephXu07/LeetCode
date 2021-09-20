package codetop;

import java.util.Arrays;

/**
 * Title: 在排序数组中查找元素的第一个和最后一个位置
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-22
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || len == 1 || nums[0] > target || nums[len - 1] < target) {
            if (len == 1 && nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }

        int left = leftEdge(nums, target);
        int right = rightEdge(nums, target);
        if (nums[left] != target && nums[right] != target) {
            return new int[]{-1, -1};
        }
        if (nums[left] != target) {
            return new int[]{right, right};
        }
        if (nums[right] != target) {
            return new int[]{left, left};
        }

        return new int[]{left, right};
    }

    private int leftEdge (int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private int rightEdge (int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return right - 1;
    }

    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置 res = new 在排序数组中查找元素的第一个和最后一个位置();
        int[] nums = {1,4};
        int target = 4;
        System.out.println(res.leftEdge(nums, target));
        System.out.println(res.rightEdge(nums, target));
        int[] ans = res.searchRange(nums, target);
        System.out.println("[" + ans[0] + "," + ans[1] + "]");
    }
}
