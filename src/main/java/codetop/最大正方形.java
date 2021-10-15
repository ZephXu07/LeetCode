package codetop;

import labuladong.Solution;

/**
 * Title: 最大正方形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 最大正方形 {
    public int maximalSquare0(char[][] matrix) {
        int max = 0;
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    max = Math.max(max, 1);
                    // 计算可能的最大正方形边长
                    int curMax = Math.min(row - i, column - j);
                    if (curMax <= max) {
                        /*
                            如果小于现在最大的边长，直接下一个
                         */
                        continue;
                    }
                    /*
                        枚举 1 到最长边长 curMax
                     */
                    for (int k = 1; k < curMax; k++) {
                        boolean flag = true;
                        /*
                            标记是否有 0 出现导致的跳出循环还是正常结束循环
                         */
                        if (matrix[i + k][j + k] == '0') {
                            /*
                                从 1 * 1 变成 2 * 2，以此类推，此处判断右下角是否为1，不为1直接跳出当前循环
                             */
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                /*
                                    判断左下方和右边是不是为1，不是则标记不用比较最长边长
                                    0 1    0 1 2
                                    2 3    3 4 5
                                           6 7 8
                                   如果 k = 1
                                   进行一次遍历，即 1，2位置，3在上面遍历了
                                   如果 k = 2
                                   进行两次遍历，需要在 k = 1的基础上的，
                                   于是在 3 * 3中，0，1，3，4是属于遍历的，8则在上面单独遍历了
                                   m = 0，遍历 2，6
                                   m = 1，遍历 5, 7
                                   以此类推，都是在上一层基础上再遍历下一层
                                 */
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            max = Math.max(max, k + 1);
                            /*
                                下标的，所以 + 1，进入下一个，如
                                1 1    1 1 1
                                1 1    1 1 1
                                       1 1 1
                             */
                        } else {
                            /*
                                如果存在一个不是，不需要枚举 k + 1 到 curMax了
                             */
                            break;
                        }
                    }
                }
            }
        }
        return max * max;
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        /*
            dp[i][j] 表示以 i,j为下标的只包含 1 的正方形的边长最长是多少，
            同时也是以 i,j为下标的只包含 1 的正方形的个数，因为边长为 3 的正方形里面有有边长 1 和 2 的正方形
            当 matrix[i][j] 为 0 时，此时不只包含 1 了，不能构成正方形，边长为 0
            当 matrix[i][j] 为 1 时，
                如果 i == 0 或者 j == 0，
                    表示在第一行或者第一列，此时即使为 1 ，边长最长为 1
                否则有
                    因为我们是从上往下，从左往右遍历的，
                    到 i, j 时，i - 1,j   i, j - 1    i - 1, j - 1
                    为下标的只包含 1 的正方形边长最大值我们是知道的
                    如果这三个值有一个为 0 ，
                        说明在 matrix[i][j] 周围的三个格子有一个为 0 ，
                        此时最大也就是自身的小格子，边长为 1
                   如果这三个值不为 0 ，画图吧，我解释不了……
                   https://pic.leetcode-cn.com/
                   8c4bf78cf6396c40291e40c25d34ef56bd524313c2aa863f3a20c1f004f32ab0-image.png

         */

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
