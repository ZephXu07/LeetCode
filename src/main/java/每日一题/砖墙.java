package 每日一题;

import java.util.*;

/**
 * Title: 砖墙
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-02
 */
public class 砖墙 {
    public int leastBricks(List<List<Integer>> wall) {
        /*
            计算每个间隙的长度，哈希表存储，间隙最多的说明穿过的砖块最少，因为 间隙 + 砖块 == 多少横砖
         */


        Map<Integer, Integer> interval = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            int len = w.size() - 1;
            for (int i = 0; i < len; i++) {
                sum += w.get(i);
                interval.put(sum, interval.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int i : interval.values()) {
            max = Math.max(max, i);
        }
        return wall.size() - max;
    }


    public static void main(String[] args) {
        砖墙 res = new 砖墙();
        List<List<Integer>> wall = new LinkedList<>();
        wall.add(new LinkedList<>(Arrays.asList(100000000)));
        wall.add(new LinkedList<>(Arrays.asList(100000000)));
        wall.add(new LinkedList<>(Arrays.asList(100000000)));
        wall.add(new LinkedList<>(Arrays.asList(100000000)));
        wall.add(new LinkedList<>(Arrays.asList(100000000)));

        System.out.println(res.leastBricks(wall));

    }
}
