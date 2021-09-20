package 快速排序;

import 归并排序.归并排序;

import java.util.Random;

/**
 * Title: 快速排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-12
 */
public class 快速排序一 {

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
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high --;
            }
            if (low < high) {
                nums[low] = nums[high];
            }
            while (low < high && nums[low] <= pivot)  {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
            }
        }
        nums[low] = pivot;
        return low;
    }


}
class TestSort {
    public static int[] randomArray() {
        Random random = new Random();
        int len = 50000000;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return nums;
    }

    public static void main(String[] args) {
        快速排序一 sort1 = new 快速排序一();
        快速排序二 sort2 = new 快速排序二();
        快速排序三 sort3 = new 快速排序三();
        快速排序四 sort4 = new 快速排序四();
        快速排序五 sort5 = new 快速排序五();
        int[] nums1 = randomArray();
        int[] nums2 = nums1.clone();
        int[] nums3 = nums1.clone();
        int[] nums4 = nums1.clone();
        int[] nums5 = nums1.clone();
        int[] nums6 = nums1.clone();

//        System.out.println(Arrays.toString(nums1));
        System.out.println("********************");
        long t1 = System.currentTimeMillis();
        sort1.quickSort(nums1);
        long t2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums1));
        System.out.println("快速排序一" + (t2 - t1) / 1000.0 + "s");

        System.out.println("********************");
        long t3 = System.currentTimeMillis();
        sort2.quickSort(nums2);
        long t4 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums2));
        System.out.println("快速排序二" + (t4 - t3)/ 1000.0 + "s");

        System.out.println("********************");
        long t5 = System.currentTimeMillis();
        sort3.quickSort(nums3);
        long t6 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums3));
        System.out.println("快速排序三" + (t6 - t5)/ 1000.0 + "s");

        System.out.println("********************");
        long t7 = System.currentTimeMillis();
        sort4.quickSort(nums4);
        long t8 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums4));
        System.out.println("快速排序四" + (t8 - t7)/ 1000.0 + "s");

        System.out.println("********************");
        long t9 = System.currentTimeMillis();
        sort5.quickSort(nums5);
        long t10 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums5));
        System.out.println("快速排序五" + (t10 - t9)/ 1000.0 + "s");

        System.out.println("********************");
        归并排序 res = new 归并排序();
        long t11 = System.currentTimeMillis();
        res.sort(nums6);
        long t12 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums5));
        System.out.println("归并排序" + (t12 - t11)/ 1000.0 + "s");
    }


}
