package 每日一题;

/**
 * Title: 猜数字大小
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-14
 */
public class 猜数字大小 {
    private int pick;
    public int guessNumber(int n) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int num) {
        pick = 6;
        return Integer.compare(pick, num);
    }

    public static void main(String[] args) {
        猜数字大小 res = new 猜数字大小();
        res.pick = 1702766719;

    }
}
