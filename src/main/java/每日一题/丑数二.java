package 每日一题;

/**
 * Title: 丑数二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-10
 */
public class 丑数二 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int two = dp[a] * 2;
            int three = dp[b] * 3;
            int five = dp[c] * 5;
            dp[i] = Math.min(Math.min(two, three), five);
            if (dp[i] == two) {
                a ++;
            }
            if (dp[i] == three) {
                b ++;
            }
            if (dp[i] == five){
                c ++;
            }
        }
        return dp[n - 1];
    }
}
