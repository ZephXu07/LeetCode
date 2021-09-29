package codetop;

/**
 * Title: 平方数之和633
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 平方数之和633 {
    public boolean judgeSquareSum(int c) {

        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
