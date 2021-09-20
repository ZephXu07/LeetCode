package 背包问题;

import java.util.Scanner;

/**
 * Title: backpack01
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-10
 */
public class backpack01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int count = Integer.parseInt(line[0]);
        int cap = Integer.parseInt(line[1]);
        int[] v = new int[count];
        int[] w = new int[count];

        for (int i = 0; i < count; i++) {
            line = in.nextLine().split(" ");
            v[i] = Integer.parseInt(line[0]);
            w[i] = Integer.parseInt(line[1]);
        }

        int[][] dp = new int[2][cap + 1];
        for (int i = 1; i <= count; i++) {
            int vol = v[i - 1];
            for (int j = 0; j <= cap; j++) {
                dp[i & 1][j] = dp[(i - 1) & 1][j];
                if (vol <= j) {
                    dp[i & 1][j] = Math.max(dp[i & 1][j], dp[(i - 1) & 1][j - vol] + w[i - 1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= cap; i++) {
            res = Math.max(res, dp[count & 1][i]);
        }
        System.out.println(res);


//        int count = 10;
//        int cap = 100;
//        int[] v = {5,32,17,7,6,29,2,14,6,1};
//        int[] w = {8,47,43,9,4,40,6,31,17,3};
//        System.out.println(a(count, cap, v, w));

    }

    private static int a (int count, int cap, int[] v, int[] w) {
        int[][] dp = new int[count + 1][cap + 1];
        for (int i = 1; i <= count; i++) {
            int vol = v[i - 1];
            for (int j = 0; j <= cap; j++) {
                dp[i][j] = dp[i - 1][j];
                if (vol <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - vol] + w[i - 1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= cap; i++) {
            res = Math.max(res, dp[count][i]);
        }
        return res;
    }
}
