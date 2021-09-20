package 每日一题;

/**
 * Title: 子数组异或查询
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-17
 */
public class 子数组异或查询 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        /*
            (0^1^2^3^4)  ^ (0^1) = 2^3^4
            使用异或前缀
         */
        int len = arr.length;
        int[] pre = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int x = queries[i][0];
            int y = queries[i][1] + 1;
            res[i] = pre[x] ^ pre[y];
        }
        return res;
    }
}
