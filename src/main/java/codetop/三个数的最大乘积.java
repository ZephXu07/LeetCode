package codetop;

/**
 * Title: 三个数的最大乘积
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-01
 */
public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        int max1 = -1003;
        int max2 = -1002;
        int max3 = -1001;
        int min1 = 1002;
        int min2 = 1001;

        for (int n : nums) {
            if (n < min2) {
                if (n < min1) {
                    min2 = min1;
                    min1 = n;
                } else {
                    min2 = n;
                }
            }
            if (n > max3) {
                if (n > max2) {
                    if (n > max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = n;
                    } else {
                        max3 = max2;
                        max2 = n;
                    }
                } else {
                    max3 = n;
                }
            }


        }
        return Math.max(max1 * min1 * min2, max1 * max2 * max3);
    }
}
