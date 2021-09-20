package 每日一题;

import java.util.Arrays;

/**
 * Title: 雪糕的最大数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-02
 */
public class 雪糕的最大数量 {
    public int maxIceCream0(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i];
            res++;
            if (sum >= coins) {
                break;
            }
        }
        return res;
    }
    public int maxIceCream(int[] costs, int coins) {
        int[] count = new int[100001];
        /*
            下标为雪糕价格，值为此价格为 i 的雪糕数量
         */
        for (int i : costs) {
            count[i]++;
        }
        int res = 0;
        for (int i = 1; i < 100001; i++) {
            if (count[i] == 0) {
                /*
                    不存在此价格的雪糕，跳过
                 */
                continue;
            }
            if (coins >= i) {
                /*
                    剩余硬币大于等于雪糕价格
                 */
                int tmp = Math.min(count[i], coins / i);
                /*
                    雪糕数量和硬币能买多少雪糕进行比较，取最小的
                 */
                res += tmp;
                /*
                    加上此雪糕数量
                 */
                coins -= tmp * i;
                /*
                    减去花费得到剩余硬币
                 */
            } else {
                /*
                    从小到大，如果硬币小于雪糕价格，说明后面的无法买，直接结束
                 */
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        雪糕的最大数量 res = new 雪糕的最大数量();
        int[] costs = {10,6,8,7,7,8};
        int coins = 5;
        System.out.println(res.maxIceCream(costs, coins));
    }
}
