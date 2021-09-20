package 每日一题;

/**
 * Title: 航班预订统计
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        /*
            差分数组
            res[0] = arr[0]
            res[i] = arr[i] - arr[i-1] i > 1

            一个范围 [a,b]增加
            只需要在 res[a] 增加相应的值 val
                此时代表着 [a,n - 1] 都增加了 val (n == arr.len)
            如果是 [a, b] 则需要在 res[b + 1] 减去相应的值
                期间的 [a+1, b] 值为 0 ，表示与前一个值的差为 0 ，表示相等
            如果 b == arr.len - 1 则不需要进行处理，因为 arr.len 已经溢出了，不存在数

            此处题目的 [a,b] 是从 1 下标开始的
            所以 a - 1 处理，b 则不需要 + 1，但要与 n判断，大于等于则溢出了，不需要处理

            最后后面加上前面的数则是原来的值
         */
        for (int[] b : bookings) {
            res[b[0] - 1] += b[2];
            if (b[1] >= n) {
                continue;
            }
            res[b[1]] -= b[2];
        }

        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
