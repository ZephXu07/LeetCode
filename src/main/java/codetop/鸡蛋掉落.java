package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 鸡蛋掉落
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-20
 */
public class 鸡蛋掉落 {
    private Map<Integer, Integer> map;
    public int superEggDrop(int k, int n) {
        map = new HashMap<>();
        return dp(k, n);
    }

    private int dp (int k, int n) {
        /*
            返回 [1,n] 层楼，k 个鸡蛋的最小试验次数
         */
        int key = n * 100 + k;
        /*
            使 map 存储的 key 唯一
         */
        if (map.containsKey(key)) {
            /*
                已经遍历过，直接返回
             */
            return map.get(key);
        }

        int res;

        if (n == 0) {
            res = 0;
            /*
                定义 0 层楼试验次数为 0
             */
        } else if (k == 1) {
            /*
                只剩一颗鸡蛋了，
                只能从 1 - n 一次次试，
                即 n 次

             */
            res = n;
        } else {
            /*
                设 f 为 [1,n] 中某个楼层
                假如摔碎了为 k - 1 鸡蛋, [1,f-1] 楼层，即 1 + dp(k-1,f-1)
                没摔碎，还有k 鸡蛋， [1,n - f]楼层，即 1 + dp(k,n-f)
                取最大的

                而 dp(k-1,f-1) 随 f 增加而增加
                dp(k,n-f) 随 f 增加而减小

                求的是两个中最大的，且 f 是属于[1,n] 都要试验，再取最小的

                所以形成一个图，dp1 = dp(k-1,f-1) 随 f 的递增函数
                dp2 = dp(k,n-f) 随 f 的递减函数

                必有交点，交点即是 min (dp(k-1,f-1), dp(k,n-f))
                同时因为两个函数是离散的，不是连续的，所以交点可能是小数
                所以需要取到此点的左右值
                 即有 dp(k - 1, left - 1), dp(k, n - left))中最大那个
                 dp(k - 1, right - 1), dp(k, n - right)中最大那个

                 两个再取最小即是所求结果


             */
            int left = 1;
            int right = n;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                int dp1 = dp(k - 1, mid - 1);
                int dp2 = dp(k, n - mid);

                if (dp1 < dp2) {
                    left = mid;
                    /*
                        交点不是整数
                     */
                } else if (dp1 > dp2) {
                    /*
                        交点不是整数
                     */
                    right = mid;
                } else {
                    /*
                        交点刚好是整数
                     */
                    left = right = mid;
                }

            }
            /*
                交点不是整数即取左右
                否则两个一致只是重复计算了，但有 map 记录
                公式不会变化
             */
            res = 1 + Math.min(Math.max(dp(k - 1, left - 1), dp(k, n - left)),
                    Math.max(dp(k - 1, right - 1), dp(k, n - right)));

        }
        map.put(key, res);
        return res;
    }
}
