package 剑指offer;

/**
 * Title: 数组中数字出现的次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-04
 */
public class 数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int xorSum = 0;
        for (int i : nums) {
            xorSum ^= i;
        }
        int part = 1;
        while ((xorSum & part) != 0) {
            part <<= 1;
        }
        int res = 0;
        int ans = 0;
        for (int i : nums) {
            if ((part & i) == 0) {
                res ^= i;
            } else {
                ans ^= i;
            }
        }
        return new int[] {res, ans};
    }
}
