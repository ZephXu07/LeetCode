package 剑指offer;

/**
 * Title: 丑数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 丑数 {
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


    public static void main(String[] args) {
        丑数 res = new 丑数();
        System.out.println(res.nthUglyNumber(10));
    }
}
