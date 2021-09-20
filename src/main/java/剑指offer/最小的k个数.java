package 剑指offer;

import java.util.*;

/**
 * Title: 最小的k个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 最小的k个数 {


//    public int[] getLeastNumbers(int[] arr, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2-i1);
//        for (int i : arr) {
//            maxHeap.add(i);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
//        }
//        int[] res = new int[k];
//        int i = 0;
//        while (!maxHeap.isEmpty()) {
//            res[i++] = maxHeap.poll();
//        }
//        return res;
//    }

    public static void main(String[] args) {
        最小的k个数 res = new 最小的k个数();
        int[] arr = {5, 4, 3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(res.getLeastNumbers(arr, k)));

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (null == arr || 0 == arr.length) {
            return new int[0];
        }
        shuffle(arr);
        int low = 0;
        int high = arr.length - 1;
        int tmp;
        while (low <= high) {
            tmp = partion(arr, low, high);
            if (tmp > k) {
                high = tmp - 1;
            } else if (tmp < k) {
                low = tmp + 1;
            } else {
                break;
            }
        }

        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partion(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        int pivot = nums[low];
        int left = low;
        int right = high + 1;
        while (true) {
            while (nums[++left] < pivot) {
                if (left == high) {
                    break;
                }
            }
            while (nums[--right] > pivot) {
                if (left == low) {
                    break;
                }
            }
            if (left >= right) {
                //防止数组递增时left = 1，right = 0 = low跳出循环，但此时left!=right时没有停止循环再次循环时-1越界
                //数组递减时left=4,right=4等于即停止
                break;
            }
            swap(nums, left, right);
            //3 1 4 5 2
            //low-left不小于pivot,right-high不大于pivot，交换left与right
            //3 1 2 5 4
            //再次循环left=4不小于pivot,right=2，left>=right，交换成2 1 3 5 4
        }
        swap(nums, low, right);
        //当递增时left=1,right=0=low，交换无效，返回0，右边大于5
        //当递减时left=4,right=4,low=0,首尾交换，返回4，左边小于5
          //杂项，right=2，左边小于3，右边大于3
        return right;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
}
