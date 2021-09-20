package 剑指offer;

import java.util.Arrays;

/**
 * Title: 青蛙跳台阶
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 青蛙跳台阶 {
    public static int numWays(int n) {
        if (0 == n || 1 == n) {
            return 1;
        }
        int pre = 1;
        int res = 0;
        int tmp = 1;
        for (int i = 1; i < n; i++) {
            res = (tmp + pre) % 1000000007;
            tmp = pre;
            pre = res;
        }
        return res;
    }


    private int[] memo;
    public int numWays1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }


    public  int helper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (0 == n || 1 == n) {
            return 1;
        }
        memo[n] = (helper(n - 1) + helper(n - 2)) % 1000000007;
        return memo[n];
    }


    public void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays1(2));
        System.out.println(numWays(7));
        System.out.println(numWays1(7));
        System.out.println(numWays(0));
        System.out.println(numWays1(0));
    }
}
