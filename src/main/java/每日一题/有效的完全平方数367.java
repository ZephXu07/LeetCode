package 每日一题;

/**
 * Title: 有效的完全平方数367
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-04
 */
public class 有效的完全平方数367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            if (product < num) {
                left = (int) (mid + 1);
            } else if (product > num) {

                right = (int) (mid - 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
