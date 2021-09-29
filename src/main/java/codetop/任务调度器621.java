package codetop;

/**
 * Title: 任务调度器621
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-23
 */
public class 任务调度器621 {
    public int leastInterval(char[] tasks, int n) {
        /*
            https://leetcode-cn.com/problems/
            task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/

            https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/

            贪心，使次数最多任务每次运行中间放置其他任务，
            若其他任务不够放置（即他们各自也需要冷却时间时）直接冷却

            如果在任务很多，冷却时间很短的时候，贪心方案会


            此外，如果任务种类很多，在安排时无需冷却时间，
            只需要在一个任务的两次出现间填充其他任务，然后从左到右从上到下依次执行即可，
            由于每一个任务占用一个时间单位，我们又正正好好地使用了tasks中的所有任务，
            而且我们只使用tasks中的任务来占用方格（没用冷却时间）。
            因此这种情况下，所需要的时间即为tasks的长度。

        由于这种情况时再用上述公式计算会得到一个不正确且偏小的结果，
        因此，我们只需把公式计算的结果和tasks的长度取最大即为最终结果。



         */
        if (n == 0) {
            return tasks.length;
        }
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        int maxFreq = 0;
        int maxCount = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                maxCount = 1;
            } else if (f == maxFreq) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * n + maxCount);


    }
}
