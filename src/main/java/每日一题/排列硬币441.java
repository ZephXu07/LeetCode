package 每日一题;

/**
 * Title: 排列硬币441
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-10
 */
public class 排列硬币441 {
    public int arrangeCoins(int n) {
        long d = (int) Math.sqrt(1 + 8L * n);
        return (int) ((d - 1) / 2);


    }

    public static void main(String[] args) {
        排列硬币441 res = new 排列硬币441();
        System.out.println(res.arrangeCoins(5));
        System.out.println(res.arrangeCoins(8));
        System.out.println(res.arrangeCoins(1804289383));
    }
}
