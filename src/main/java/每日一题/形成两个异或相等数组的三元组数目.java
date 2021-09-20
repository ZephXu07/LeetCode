package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 形成两个异或相等数组的三元组数目
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-18
 */
public class 形成两个异或相等数组的三元组数目 {
    public int countTriplets(int[] arr) {
        /*
            由上述解法有 pre[i] = pre[k + 1]，此时 k 有多个对应的 i，而 k又有多个取值
            于是有：(k-i1)+(k-i2)+...+(k-im) = m * k - (i1+i2+...+im)
            于是对于每个下标，统计出现的次数 m，及对应的下标的和

            再可在前缀和计算中寻找，一次遍历
         */
        int len = arr.length;

        int res = 0;
        int pre = 0;
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        for (int k = 0; k < len ; k++) {
            //这里是遍历原数组
            int val = pre ^ arr[k];
            if (m.containsKey(val)) {
                //这里是遍历前缀异或和的
                res += m.get(val) * k - sum.get(val);
            }
            m.put(pre, m.getOrDefault(pre, 0) + 1);
            //pre[k]的次数
            sum.put(pre, sum.getOrDefault(pre, 0) + k);
            //pre[k]的下标和

            pre = val;
        }

        return res;


    }
}
