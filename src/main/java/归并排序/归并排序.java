package 归并排序;

import java.util.Arrays;

/**
 * Title: 归并排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-12
 */
public class 归并排序 {
    public void sort (int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort (int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge (int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int inx = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[inx++] = arr[l++];
            } else {
                tmp[inx++] = arr[r++];
            }
        }
        if (l <= mid) {
            System.arraycopy(arr, l, tmp, inx,mid - l + 1);
        }
        if(r <= right){
            System.arraycopy(arr, r, tmp, inx,right - r + 1);
        }
        System.arraycopy(tmp,0, arr, left,right - left + 1);
    }

    public static void main(String[] args) {
        归并排序 res = new 归并排序();
        int[] nums = {169,218,217,369,493,93,460,551,754,431,34,932,644,576,560,12,324,176,867,29,399,62,848,980,549,98,938,121,923,661,744,767,873,419,764,317,164,656,997,399,278,552,437,853,993,5,332,643,759,541,803,919,293,849,562,335,396,983,635,424,807,537,596,640,255,868,425,37,186,482,568,571,863,505,987,339,764,890,745,518,497,242,133,22,122,556,502,301,576,917,605,732,601,366,955,302,996,654,560,898};
        res.sort(nums);
        int inx = 1;
        for (int i : nums) {
            System.out.print(i + " ");
            if (inx++ % 10 == 0) {
                System.out.println();
            }
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
    }

}
