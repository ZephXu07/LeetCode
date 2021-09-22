package codetop;

/**
 * Title: 统计全1子矩形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-22
 */
public class 统计全1子矩形 {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        /*
            以 mat[i][j] 结尾的第 i 行连续 1 的长度
            初始化：因为第 0 列前面没有，因为当
            mat[i][0] = 1 时  dp[i][0] = 1
         */
        for (int i = 0; i < row; i++) {
            dp[i][0] = mat[i][0];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (mat[i][j] == 1) {
                    /*
                        当前 mat[i][j] = 1
                        则以 mat[i][j] 结尾的第 i 行的连续 1 长度
                        则要看当行前一个位置的连续 1 长度
                     */
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = dp[i][j];
                for (int k = i; k >= 0 && tmp != 0; k--) {
                    /*
                        从左到右遍历，当有连续 1 时
                        假如是 2 个连续1
                        第一次访问第一个连续 1 ，+1
                        第二次访问第二个连续 1，此时长度是2， +2，
                        表示了第二次访问的 1 单独一次，与前面的1再连在一起再计算一次

                        高度则是从自身当行开始
                        不断往上，直到溢出
                        同时维护最小的长度，因为是矩形
                        如果中途出现了 1 则停止

                        https://leetcode-cn.com/problems/
                        count-submatrices-with-all-ones/solution/
                        tong-ji-quan-1-zi-ju-xing-by-leetcode-solution/
                     */
                    tmp = Math.min(tmp, dp[k][j]);
                    res += tmp;
                }
            }
        }
        return res;
    }
}
