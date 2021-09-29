package 每日一题;

import java.util.Arrays;

/**
 * Title: 超级洗衣机
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 超级洗衣机 {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int len = machines.length;
        if (sum % len != 0) {
            return -1;
        }

        int avg = sum / len;

        int res = 0;
        int pre = 0;
        for (int i = 0; i < machines.length; i++) {
            pre += machines[i];
            res = Math.max(res,
                    Math.max(machines[i] - avg, Math.abs(pre - avg * (i + 1))));
        }

        return res;
        /*
            每台洗衣机，每次只能将一件衣服送到相邻的一台洗衣机。

            设 MaxMax 是最多的衣服数量最多的一个洗衣机的衣服数量，
            AvgAvg 等于最后每台洗衣机中衣物的数量相等的数量。

            因为每次只能移动一件衣服，所有对于衣服数量最多的一个洗衣机，
            最少需要 Max - AvgMax−Avg 次转移。
            因为每次只能往相邻的洗衣机转移一件衣服，所以假设前 i 个洗衣机的衣服总和为 pre，
            那么至少需要 |pre - i * Avg| 次转移，
            才能使 前i个 和 前 i个后面 洗衣机中的衣服相等。
            若 sum - i * Avg > 0 则表示 前 i个洗衣机，向 i个洗衣机后面转移;
            若 sum - i * Avg <= 0 则表示  i个后面的洗衣机，向 前 i个洗衣机转移。
            两者情况取最大值。

         */

    }
}
