package codetop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: 合并区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-06
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int len = intervals.length;
        int[][] res = new int[len][2];
        int inx = 0;
        int[] last;
        int[] cur;
        res[0] = intervals[0];
        for (int i = 1; i < len; i++) {
            cur = intervals[i];
            last = res[inx];
            /*
                指向结果集当前区间
             */
            if (cur[0] <= last[1]) {
                /*
                    当前遍历的区间与结果集当前区间有交集
                    （或边界的交集）
                    更新结果集当前区间的右边界
                 */
                last[1] = Math.max(last[1], cur[1]);
            } else {
                /*
                    当前遍历的区间的左边界大于结果集当前区间的右边界
                    新加一个结果集区间，指向当前遍历的 cur 区间
                 */
                res[++inx] = cur;
            }

        }
        int[][] array = new int[inx + 1][2];
        /*
            inx是下标，长度要 + 1
         */
        System.arraycopy(res, 0, array, 0, inx + 1);
        /*
            复制回去，因为 res 长度大于等于要返回的结果
         */
        return array;
    }
}
