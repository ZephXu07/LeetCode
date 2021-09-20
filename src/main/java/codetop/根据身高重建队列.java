package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 根据身高重建队列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        /*
            [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
          ->
            [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
          ->
            [[7,0]]
            [[7,0],[7,1]]
            [[7,0],[6,1],[7,1]]
            [[5,0],[7,0],[6,1],[7,1]]
            [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
         */
        Arrays.sort(people, (p1, p2)-> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });

        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
