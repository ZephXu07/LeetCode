package twotwotwo周赛;

import java.util.*;

/**
 * Title: 大餐计数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-03
 */
public class 大餐计数 {
    public int countPairs(int[] deliciousness) {
        if (null == deliciousness || deliciousness.length < 2) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        long ans = 0;
        int[] sum = new int[22];
        sum[0] = 1;
        for (int i = 1; i < 22; i++) {
            sum[i] = sum[i - 1] * 2;
        }
        for (int i = 0;i < deliciousness.length;++i){
            for (int j = 0; j < 22; ++j){
                int target = sum[j];
                if (target - deliciousness[i] < 0) {
                    continue;
                }
                if (map.containsKey(target - deliciousness[i])){
                    ans += map.get(target - deliciousness[i]);
                }
            }
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0) + 1);
        }
        ans %= (1e9 + 7);
        return (int)ans;
    }




    public static void main(String[] args) {
        大餐计数 res  = new 大餐计数();
        int[] deliciousness = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        System.out.println(res.countPairs(deliciousness));
    }
}
