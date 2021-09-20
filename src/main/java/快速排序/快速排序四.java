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
public class 快速排序四 {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (high - low <= 47) {
            insertSort(nums, low, high);
            return;
        }
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int mid = low + (high - low) >> 1;
        if (nums[low] > nums[high]) {
            swap(nums, low, high);
        }
        if (nums[mid] > nums[high]) {
            swap(nums, mid, high);
        }
        if (nums[low] < nums[mid]) {
            swap(nums, low, mid);
        }
        int pivot = nums[low];
        int inx = low;
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high --;
            }
            while (low < high && nums[low] <= pivot)  {
                low++;
            }
            if (low >= high) {
                break;
            }
            swap(nums, low, high);
        }
        swap(nums, inx, low);
        nums[low] = pivot;
        return low;
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
