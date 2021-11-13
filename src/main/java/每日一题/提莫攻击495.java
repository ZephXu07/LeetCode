package 每日一题;

/**
 * Title: 提莫攻击495
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-10
 */
public class 提莫攻击495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = duration;
        int cur = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= cur) {
                res += timeSeries[i] + duration - cur;
            } else {
                res += duration;
            }
            cur = timeSeries[i] + duration;
        }
        return res;
    }
}
