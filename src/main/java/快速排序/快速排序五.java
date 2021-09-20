package 快速排序;

import java.util.Arrays;

/**
 * Title: 快速排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-12
 */
public class 快速排序五 {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (high - low <= 7) {
            insertSort(nums, low, high);
            return;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[low] > nums[high]) {
            swap(nums, low, high);
        }
        if (nums[mid] > nums[high]) {
            swap(nums, mid, high);
        }
        if (nums[low] < nums[mid]) {
            swap(nums, low, mid);
        }
        int left = low,  i = low + 1, right = high;
        int pvoit = nums[low];
        while (i <= right) {
            if (pvoit < nums[i]) {
                swap(nums, i, right);
                right--;
            } else if (pvoit == nums[i]) {
                i++;
            } else {
                swap(nums,left,i);
                left++;
                i++;
            }
        }
        sort(nums, low, left - 1);
        sort(nums,right + 1, high);
    }


    private void insertSort(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > tmp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
