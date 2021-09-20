package 剑指offer;

import java.util.*;

/**
 * Title: n个骰子的点数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class n个骰子的点数 {
    //超时
    private Map<Integer, Integer> sum;
    public double[] dicesProbability(int n) {
        sum = new LinkedHashMap<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(track, n);
        double[] count = new double[sum.size()];
        int index = 0;
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            total += entry.getValue();
            count[index++] = entry.getValue();
        }
        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] / total;
        }
        return count;
    }

    private void backTrack(LinkedList<Integer> track, int n) {
        if (track.size() == n) {
            int tmp = addSum(track);
            if (sum.containsKey(tmp)) {
                sum.put(tmp, sum.get(tmp) + 1);
            } else {
                sum.put(tmp, 1);
            }
            return;
        }
        for (int i = 1; i <= 6; i++) {
            track.add(i);
            backTrack(track, n);
            track.removeLast();
        }
    }

    private int addSum (LinkedList<Integer> track) {
        int sum = 0;
        for (int i : track) {
            sum += i;
        }
        return sum;
    }

    public double[] dicesProbabilityDp(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double sum = Math.pow(6d, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / sum;
        }
        return res;
    }

    public double[] dicesProbabilityDpOptimized(int n) {

        int[] dp = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * i; j >= i; j--) {
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[j] += dp[j - k];
                }
            }
        }
        double sum = Math.pow(6d, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[i] / sum;
        }
        return res;
    }

    public static void main(String[] args) {
        n个骰子的点数 res = new n个骰子的点数();
        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(res.dicesProbabilityDp(3)));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        long t3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(res.dicesProbabilityDpOptimized(3)));
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }
}
