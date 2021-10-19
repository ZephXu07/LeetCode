package 杂类;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: 无重叠区间435
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-19
 */
public class 无重叠区间435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int res = 1;
        int end = intervals[0][1];
        for (int[] inter: intervals) {
            int start = inter[0];
            if (start >= end) {
                res ++;
                end = inter[1];
            }
            /*
                https://leetcode-cn.com/problems/
                non-overlapping-intervals/solution/435-wu-zhong-die-qu-jian-tan-xin-jing-di-qze0/
             */
        }
        return intervals.length - res;
    }
}
