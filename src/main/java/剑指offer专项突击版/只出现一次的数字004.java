package 剑指offer专项突击版;

/**
 * Title: 只出现一次的数字004
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 只出现一次的数字004 {
    public int singleNumber(int[] nums) {
        /*
            统计每一个二进制位上的值的和，
            取余三则是出现的一次的数字的二进制的值
         */
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += num >> i & 1;
                /*
                    num >> i & 1
                    得到 num 从右往左 i 位上的值
                 */
            }
            if (count % 3 != 0) {
                res |= 1 << i;
                /*
                    设置 res 从右往左 i 位上的值
                 */
            }
        }
        return res;
    }
}
