package 杂类;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 可以到达所有点的最少点数目1557
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-02
 */
public class 可以到达所有点的最少点数目1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new LinkedList<>();
        int[] count = new int[n];
        for (List<Integer> e : edges) {
            count[e.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
