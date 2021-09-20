package codetop;

/**
 * Title: 把数字翻译成字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-25
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            dp[i % 3] = dp[(i - 1) % 3];
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("25") <= 0 && tmp.compareTo("10") >= 0) {
                dp[i % 3] += dp[(i - 2) % 3];
            }
        }

        return dp[len % 3];


    }

    public static void main(String[] args) {
         把数字翻译成字符串 res = new 把数字翻译成字符串();
        System.out.println(res.translateNum(12258));
    }
}
