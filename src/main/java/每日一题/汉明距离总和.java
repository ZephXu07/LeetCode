package 每日一题;

/**
 * Title: 汉明距离总和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-28
 */
public class 汉明距离总和 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
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
