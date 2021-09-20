package codetop;

/**
 * Title: 汉明距离总和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 汉明距离总和 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        /*
            计算数组中每两个数中二进制位 1 的数目之差的和
            每一个二进制位，统计1的次数，自然得到 0 的次数，乘法原理
            假如当前是第 i 位，知道了所有数此位上 1 个数为 x
            则 0 个数为 len - x = y
            此时运用乘法原理，即可知道
            4 (0100)
            14 (1110)
            2 (0010)
            假设计算第 2 位(右往左，0开始）
            4  14 = 0
            4  2  = 1
            14 2  = 1
            等于 2 * 1 = 2
            即 2 个 1 与 1 个 0 多少种排列方式（多个相同的数视为不同）
        */
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int n : nums) {
                c += (n >> i) & 1;
            }
            res += c * (nums.length - c);
        }
        return res;

    }
}
