package 剑指offer;

/**
 * Title: 数组中数字出现的次数II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int n : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                if ((n & bitMask) != 0) {
                    bit[i] ++;
                }
                bitMask <<= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res ^= bit[i] % 3;
        }
        return res;
    }
}
