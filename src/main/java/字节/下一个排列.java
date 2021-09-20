package 字节;

import java.util.Arrays;

/**
 * Title: 下一个排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-26
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int pre = nums.length - 2;
        while (pre >= 0 && nums[pre] >= nums[pre + 1]) {
            pre--;
        }
        if (pre < 0) {
            reverse(nums, 0);
            return;
        }
        int cur = pre + 1;
        while (cur < nums.length && nums[cur] > nums[pre]) {
            cur++;
        }
        cur --;
        swap(nums, pre, cur);
        reverse(nums, pre + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int[] arr, int i) {
        int j = arr.length - 1;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

    }
}
