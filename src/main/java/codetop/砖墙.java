package codetop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 砖墙
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 砖墙 {
    public int leastBricks(List<List<Integer>> wall) {
        /*
            计算每个间隙的长度，哈希表存储，间隙最多的说明穿过的砖块最少，因为 间隙 + 砖块 == 多少横砖
            map 存储砖墙间隔的的位置，即一块砖的长度、两块砖的长度......直到遍历完除了最后的砖
            因为起始和结尾不算

            间隔相同的次数最多，则证明穿过的砖最少
            用砖的行数 - 间隔数 = 穿过的砖数
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            int len = w.size() - 1;
            for (int i = 0; i < len; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }
        return wall.size() - max;
    }
}
