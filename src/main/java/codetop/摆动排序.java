package codetop;

import java.util.Arrays;

/**
 * Title: 摆动排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-16
 */
public class 摆动排序 {
    public static void wiggleSort (int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            } else if ((i & 1) == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
//        int[] nums = {3,5,2,1,6,4};
        int[] nums = {3,5,10,5,2,6,2,1,6,4,8,9,6,2,4,51,3,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }
}
