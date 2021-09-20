package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 大餐计数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-11
 */
public class 大餐计数 {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        int max = 0;
        for (int d : deliciousness) {
            max = Math.max(d, max);
        }
        max *= 2;
        /*
           寻找计算最大的 2 的幂
         */
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int d : deliciousness) {
            /*
                对每一个数组的值进行遍历，寻找与其的和为 2 的幂的数（从 1 到上述的最大）的次数
             */
            for (int i = 1; i <= max; i *= 2) {
                res = (res + map.getOrDefault(i - d, 0)) % mod;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return res;
    }
}
