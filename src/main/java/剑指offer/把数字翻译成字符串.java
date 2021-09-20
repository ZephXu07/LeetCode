package 剑指offer;

/**
 * Title: 把数字翻译成字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 把数字翻译成字符串 {
    public int translateNumByDp(int num) {
        int len = 1;
        int tmp = num / 10;
        while (tmp != 0) {
            len++;
            tmp /= 10;
        }
        if (len == 1) {
            return 1;
        }
        int[] arr = new int[len];
        for (int i = 0; num != 0; i++) {
            arr[len - i - 1] = num % 10;
            num /= 10;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            tmp = arr[i - 2] * 10 + arr[i - 1];
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    public int translateNumByDpOptimized(int num) {
        int len = 1;
        int tmp = num / 10;
        while (tmp != 0) {
            len++;
            tmp /= 10;
        }
        if (len == 1) {
            return 1;
        }
        int[] arr = new int[len];
        for (int i = 0; num != 0; i++) {
            arr[len - i - 1] = num % 10;
            num /= 10;
        }
        int dp_0 = 1;
        int dp_1 = 1;
        int res = 1;
        for (int i = 2; i <= len; i++) {
            tmp = arr[i - 2] * 10 + arr[i - 1];
            if (tmp >= 10 && tmp <= 25) {
                res = dp_0 + dp_1;

            } else {
                res = dp_1;
            }
            dp_0 = dp_1;
            dp_1 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        把数字翻译成字符串 res = new 把数字翻译成字符串();
        System.out.println(res.translateNumByDp(0));
        System.out.println(res.translateNumByDpOptimized(0));
    }
}
