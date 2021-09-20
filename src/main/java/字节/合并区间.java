package 字节;

import java.util.Arrays;

/**
 * Title: 合并区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> (Integer)(o1[0] - o2[0]));
        int[][] res = new int[intervals.length][2];
        int index = 0;
        int[] last;
        int[] curr;
        res[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            curr = intervals[i];
            last = res[index];
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res[++index] = curr;
            }

        }
        int[][] array = new int[index + 1][2];
        System.arraycopy(res, 0, array, 0, index + 1);
        return array;
    }
}
