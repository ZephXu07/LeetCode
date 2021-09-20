package codetop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: 删除被覆盖区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-06
 */
public class 删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0]);
        /*
            左从小到大排序，右大到小
            当左相同时，右大的在前面，则后面的遍历的因为右边界小被覆盖了，count++

            |______|
                |______|    没有被覆盖，下一个

             |_____|
             |___|      被覆盖，，count++

             |__________|
                        |_______|   没有被覆盖，下一个

             |_____________|
                |________|              被覆盖，，count++

             |______|
             |______|   没有这种情况

         */
        int len = intervals.length;
        int count = 0;
        int pre = 0;
        int cur;
        for (int i = 0; i < len; i++) {
            cur = intervals[i][1];
            if (pre < cur) {
                pre = cur;
                count++;
            }
        }
        return count;
    }
}
