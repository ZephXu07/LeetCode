package codetop;

import java.util.Scanner;

/**
 * Title: 计算数组的小和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-13
 */
public class 计算数组的小和 {
    public long getSmallSum (int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private long mergeSort (int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        long l = mergeSort(nums, left, mid);
        long r = mergeSort(nums, mid + 1, right);
        long c = merge(nums, left, mid, right);
        return l + r + c;
    }

    private long merge (int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int inx = 0;
        int l = left;
        int r = mid + 1;
        long samllSum = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                samllSum += (long) nums[l] * (right - r + 1);
                tmp[inx++] = nums[l++];
            } else {
                tmp[inx++] = nums[r++];
            }
        }
        if (l <= mid) {
            System.arraycopy(nums, l, tmp, inx,mid - l + 1);
        }
        if(r <= right){
            System.arraycopy(nums, r, tmp, inx,right - r + 1);
        }
        System.arraycopy(tmp,0, nums, left,right - left + 1);
        return samllSum;
    }


    public static void main(String[] args) {
        计算数组的小和 main = new 计算数组的小和();
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(main.getSmallSum(nums));
    }
}
