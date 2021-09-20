package 每日一题;

/**
 * Title: 你能在你最喜欢的那天吃到你最喜欢的糖果吗
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-01
 */
public class 你能在你最喜欢的那天吃到你最喜欢的糖果吗 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int canLen = candiesCount.length;
        //糖果类型
        int queLen = queries.length;
        //询问次数
        boolean[] res = new boolean[queLen];
        //结果

        long[] pre = new long[canLen + 1];
        //long类型是因为第 63 个测试例子会溢出
        for (int i = 0; i < canLen; i++) {
            pre[i + 1] = pre[i] + candiesCount[i];
        }
        //前缀和，第 (i - 1)种糖果之前的那些糖果总数

        for (int i = 0; i < queLen; i++) {
            int type = queries[i][0];
            //想吃的类型
            int day = queries[i][1];
            //想吃的那天
            int cap = queries[i][2];
            //此次查询每天最多吃的糖数目

            /*
                吃某种糖果，当想吃的那天在最早吃到和最晚吃到这两天之间怎样分配都行，结果为true，否则false
                最早那天，当然是前面的所有糖果数目 / 每天最大吃的数目
                最晚那天，是前面所有糖果，再加上此类型的糖果数目减一，剩一颗最晚那天吃，此时是每天吃一颗

                long类型防溢出

             */
            long early =  pre[type] / cap;
            long late = pre[type + 1] - 1;
            if (early <= day && day <= late) {
                res[i] = true;
            }
        }

        return res;

    }
}
