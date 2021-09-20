package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 乘积最大子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-01
 */
public class 乘积最大子数组 {
//    private int res;
//    public int maxProduct(int[] nums) {
//        res = Integer.MIN_VALUE;
//        List<Integer> zero = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            res = Math.max(res, nums[i]);
//            if (nums[i] == 0) {
//                zero.add(i);
//            }
//        }
//        if (zero.size() >= 1) {
//            int start = 0;
//            int end = 0;
//            for (int i = 0; i < zero.size(); i++) {
//                end = zero.get(i);
//                if (end - start >= 2) {
//                    max(nums, start, end - start);
//                }
//                start = end + 1;
//            }
//            if (end != nums.length - 1) {
//                max(nums, start, nums.length - start);
//            }
//
//        } else {
//            max(nums, 0, nums.length);
//        }
//        return res;
//    }
//
//    public void max(int[] nums, int start, int len) {
//        int[] pre = new int[nums.length + 1];
//        pre[start] = 1;
//        for (int i = start; i < len + start; i++) {
//            res = Math.max(res, nums[i]);
//            pre[i + 1] = pre[i] * nums[i];
//        }
//        for (int i = start; i < len + start; i++) {
//            for (int j = i + 1; j <= len + start; j++) {
//                res = Math.max(res, pre[j] / pre[i]);
//            }
//        }
//    }

    public int maxProduct(int[] nums) {
        /*
            由于存在负数，
            那么会导致最大的变最小的，
            最小的变最大的
         */
        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int n : nums) {
            if (n < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * n, n);
            min = Math.min(min * n, n);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        乘积最大子数组 res = new 乘积最大子数组();
        System.out.println(res.maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
        System.out.println(res.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(res.maxProduct(new int[]{-2,0,-1}));
    }
}
