package labuladong;

import java.util.Arrays;
import java.util.Random;

/**
 * Title: labuladong.FindKthLargest
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        // 索引转化
        k = nums.length - k;
        while (lo <= hi) {
            // 在 nums[lo..hi] 中选一个分界点
            int p = partition(nums, lo, hi);
            if (p < k) {
                // 第 k 大的元素在 nums[p+1..hi] 中
                lo = p + 1;
            } else if (p > k) {
                // 第 k 大的元素在 nums[lo..p-1] 中
                hi = p - 1;
            } else {
                // 找到第 k 大元素
                return nums[p];
            }
        }
        return -1;
    }


    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo){
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }


    private void shuffle(int[] nums) {
        int len = nums.length;
        Random random = new Random();
        int j;
        for (int i = 0; i < len; i++) {
            j = i + random.nextInt(len - i);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {5,4,3,2,1};
        int[] nums = {1,2,3,4,5};
//        int[] nums = {3,1,4,5,2};
        FindKthLargest res = new FindKthLargest();
        int partition = res.partition(nums, 0, 4);
        System.out.println(partition);
        System.out.println(Arrays.toString(nums));
    }
}
