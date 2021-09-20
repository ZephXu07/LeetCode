package 每日一题;

/**
 * Title: 位一的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-22
 */
public class 位一的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= 0;
            res++;
        }
        return res;
    }
}
