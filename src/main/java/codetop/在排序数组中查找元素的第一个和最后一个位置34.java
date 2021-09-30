package codetop;

import java.util.Arrays;

/**
 * Title: 在排序数组中查找元素的第一个和最后一个位置34
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0
                || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int left = getLeft(nums, target);
        int right = getRight(nums, target);

        if (left == -1 && right == -1) {
            return new int[]{-1, -1};
        }
        if (left == -1) {
            return new int[]{right, right};
        }
        if (right == -1) {
            return new int[]{left, left};
        }
        return new int[]{left, right};
    }

    private int getLeft (int[] nums, int target) {
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
        return nums[left] == target ? left : -1;
    }

    private int getRight (int[] nums, int target) {
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
        return nums[left] == target ? left : -1;
    }


    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置34 res = new 在排序数组中查找元素的第一个和最后一个位置34();
        System.out.println(Arrays.toString(res.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
