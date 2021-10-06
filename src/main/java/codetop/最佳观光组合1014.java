package codetop;

/**
 * Title: 最佳观光组合1014
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 最佳观光组合1014 {
    public int maxScoreSightseeingPair(int[] values) {


        /*
            values[i] + values[j] + i - j
            values[i] + i  --> pre
            values[j] - j  --> cur
         */
        int pre = values[0] + values[0];
        int cur = 0;

        int res = 0;
        for (int i = 1; i < values.length; i++) {
            cur = values[i] - i;
            res = Math.max(res, pre + cur);
            pre = Math.max(pre, values[i] + i);
        }
        return res;

    }
}
