package 二三九周赛;

import java.util.Arrays;

/**
 * Title: 到目标元素的最小距离
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-02
 */
public class 到目标元素的最小距离 {
    public static int getMinDistance(int[] nums, int target, int start) {
//        Arrays.sort(nums);
//        int low = 0;
//        int high = nums.length - 1;
//
//        while (low < high) {
//            int mid = (low + high) / 2;
//
//            if (nums[mid] < target) {
//                low = mid + 1;
//            } else if (nums[mid] > target) {
//                high = mid;
//            } else if (nums[mid] == target) {
//                high = mid;
//            }
//        }
//        return Math.abs(low - start);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(Math.abs(i - start), res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,6};
        int target = 5, start = 2;
        System.out.println(getMinDistance(nums, target, start));
    }
}
