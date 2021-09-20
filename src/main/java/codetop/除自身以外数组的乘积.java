package codetop;

/**
 * Title: 除自身以外数组的乘积
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 除自身以外数组的乘积 {
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] left = new int[len];
//        int[] right = new int[len];
//
//        int sum = 1;
//        for (int i = 0; i < len; i++) {
//            left[i] = sum;
//            sum *= nums[i];
//        }
//
//        sum = 1;
//
//        for (int i = len - 1; i >= 0; i--) {
//            right[i] = sum;
//            sum *= right[i];
//        }
//
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            res[i] = left[i] * right[i];
//        }
//
//        return res;
//
//    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r *= nums[i];
        }

        return res;
    }
}
