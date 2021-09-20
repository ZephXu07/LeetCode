package 快速排序;

import java.util.Random;

/**
 * Title: 快速排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-12
 */
public class 快速排序二 {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
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

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
