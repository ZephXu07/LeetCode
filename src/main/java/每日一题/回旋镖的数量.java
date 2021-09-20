package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 回旋镖的数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int m : map.values()) {
                /*
                    排列 A(2,m) = m * (m - 1)
                 */
                res += m * (m - 1);
            }
        }
        return res;
    }

    private int getDist (int[] x, int[] y) {
        int a = Math.abs(x[0] - y[0]);
        int b = Math.abs(x[1] - y[1]);
        return a * a + b * b;
    }
}
