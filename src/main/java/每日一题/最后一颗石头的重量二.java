package 每日一题;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Title: 最后一颗石头的重量二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-08
 */
public class 最后一颗石头的重量二 {
    public int lastStoneWeightII(int[] stones) {
        /*
            为什么可以转化

            简单理解
            a还是b,一起消失为 0 ，也是一个 + ，一个 -
            不一起消失 ( + a - b) 或 (+ b - a)
            如果和另外石子一起，假设是 + ，则有 (+ a - b) 或者 (+ b - a)
                                 -   则有 (+ b - a) 或者 (+ a - b)
                                 加减平衡，最终所求还是全部的和，再减去 一堆加的和，一堆减的和，

             或者这样理解
             就是两堆石子，使差值的绝对值小，即最后剩下的石子最小
             假设两堆石子的差值绝对值最小，最大重量的石子在的那堆为A，另一堆为B
             A取最大的石子，B中任取一个，减去B石子重量，此时A石子重量 >= 0，
             为 0 则刚好，否则再将其放回A 中
             再一次开始，重新定义 A 与 B，重新计算
             在此过程中，A 与 B 不断减去相同的质量，直到最后两个时，相同则一起消失，则差值最小为 0
             否则的话，至少有一个大，且两个石堆各自的石子数量一定是 1 ，否则与原先设定的 A ，B差值绝对值最小不符合
             因为此时 有一堆是多个石子，一个是 0 个石子，此时差值绝对值绝对不是最大的


            - 号的和，a
            由于都是非负整数，a >= 0，数组的和 sum >= 0, - 号的和 (sum - a) >= 0
            则 (sum - a) - a 的值是所求的值
            即 sum - 2 * a = val
            选择和为 a 的元素

            dp[i][j] 前 i 个石子中凑到最接近于 j 的质量，即 a
            最后是 (sum - a) - a ，
         */
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        int len = stones.length;
        int neg = sum / 2;
        int[][] dp = new int[len + 1][neg + 1];
        /*
            i   前 i 个数，从 1 开始数
            j   数和为 j
         */

        for (int i = 1; i <= len; i++) {
            int n = stones[i - 1];
            // 对每一个数进行选择与否
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                /*
                    不选当前数，则现在的值是上一个的值 dp[i - 1][j]
                 */

                if (n <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - n] + n);
                    /*
                        选了当前的数，则需要从，
                        即要把前 i - 1 个数最接近 j - n 的值找到，
                        再加上当前数，因为是最接近的，不是等于
                     */
                }
            }
        }
        return sum - 2 * dp[len][neg];
    }

    public int lastStoneWeightII1(int[] stones) {
        /*
            为什么可以转化

            简单理解
            a还是b,一起消失为 0 ，也是一个 + ，一个 -
            不一起消失 ( + a - b) 或 (+ b - a)
            如果和另外石子一起，假设是 + ，则有 (+ a - b) 或者 (+ b - a)
                                 -   则有 (+ b - a) 或者 (+ a - b)
                                 加减平衡，最终所求还是全部的和，再减去 一堆加的和，一堆减的和，

             或者这样理解
             就是两堆石子，使差值的绝对值小，即最后剩下的石子最小
             假设两堆石子的差值绝对值最小，最大重量的石子在的那堆为A，另一堆为B
             A取最大的石子，B中任取一个，减去B石子重量，此时A石子重量 >= 0，
             为 0 则刚好，否则再将其放回A 中
             再一次开始，重新定义 A 与 B，重新计算
             在此过程中，A 与 B 不断减去相同的质量，直到最后两个时，相同则一起消失，则差值最小为 0
             否则的话，至少有一个大，且两个石堆各自的石子数量一定是 1 ，否则与原先设定的 A ，B差值绝对值最小不符合
             因为此时 有一堆是多个石子，一个是 0 个石子，此时差值绝对值绝对不是最大的


            - 号的和，a
            由于都是非负整数，a >= 0，数组的和 sum >= 0, - 号的和 (sum - a) >= 0
            则 (sum - a) - a 的值是所求的值
            即 sum - 2 * a = val
            选择和为 a 的元素

            dp[i][j] 前 i 个石子中凑到最接近于 j 的质量，即 a
            最后是 (sum - a) - a ，
         */
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        int len = stones.length;
        int neg = sum / 2;
        int[][] dp = new int[2][neg + 1];
        /*
            i   前 i 个数，从 1 开始数
            j   数和为 j
         */

        for (int i = 1; i <= len; i++) {
            int n = stones[i - 1];
            // 对每一个数进行选择与否
            for (int j = 0; j <= neg; j++) {
                dp[i & 1][j] = dp[(i - 1) & 1][j];
                /*
                    不选当前数，则现在的值是上一个的值 dp[i - 1][j]
                 */

                if (n <= j) {
                    dp[i & 1][j] = Math.max(dp[i & 1][j], dp[(i - 1) & 1][j - n] + n);
                    /*
                        选了当前的数，则需要从，
                        即要把前 i - 1 个数最接近 j - n 的值找到，
                        再加上当前数，因为是最接近的，不是等于
                     */
                }
            }
        }
        return sum - 2 * dp[len & 1][neg];
    }



    public static void main(String[] args) {
        最后一颗石头的重量二 res = new 最后一颗石头的重量二();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(res.lastStoneWeightII(stones));
        System.out.println(res.lastStoneWeightII1(stones));
    }

}
