package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 最大矩形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 最大矩形 {
//    public int maximalRectangle(char[][] matrix) {
//        if (0 == matrix.length) {
//            return 0;
//        }
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] left = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == '1') {
//                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
//                }
//            }
//        }
//        /*
//            计算 (i,j)在这行有多少个连续的1，
//            此处是矩形的右下角
//         */
//        int res = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == '0') {
//                    continue;
//                    /*
//                        当前点是0，直接忽略
//                     */
//                }
//                int wid = left[i][j];
//                /*
//                    暂时的宽度
//                 */
//                int area = wid;
//                /*
//                    暂时的面积 = 暂时的宽度 * 1
//                 */
//                for (int k = i - 1; k >= 0; k--) {
//                    /*
//                        以 (i,j) 为右下角，寻找 j 这一列上  i -> 0 的矩形的宽度，
//                        如果有更小的，说明上一行的某一列出现了1
//                        使宽度变小，于是宽度 * (i-k+1)的长度 == 面积
//                        进行比较，寻找到 (i,j) 为右下角的最大的矩形面积
//
//                     */
//                    wid = Math.min(wid, left[k][j]);
//                    area = Math.max(area, (i - k + 1) * wid);
//                }
//                res = Math.max(area, res);
//                /*
//                    计算每个 (i,j) 的最大的矩形面积，取最大，则是题目的结果
//                 */
//            }
//        }
//        return res;
//    }

    public int maximalRectangle(char[][] matrix) {
        if (0 == matrix.length) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] left = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        /*
            计算 (i,j)在这行有多少个连续的1，
            此处是矩形的右下角
         */

        /*
            https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
            使用这道题的单调栈的方法优化，对每一列进行枚举，原本的高即是 left[i][j] 连续的 i 的列数
         */
        int res = 0;
        for (int j = 0; j < cols; j++) {
            int[] ll = new int[rows];
            int[] rr = new int[rows];
            Deque<Integer> stack = new LinkedList<>();
            //以height[i]为最低，向两边寻找比其还低的边界，(r - l - 1) * 高则是此点的为最低的面积
            //若左边界没有则为-1，右边界没有则为len， len - (-1) - 1刚好就是长度，不需额外处理
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                ll[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            //单调栈，寻找左边比height[i]稍低一点的坐标
            stack.clear();
            for (int i = rows - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
               rr[i] = stack.isEmpty() ? rows : stack.peek();
                stack.push(i);
            }
            //单调栈，寻找右边比height[i]稍低一点的坐标

            for (int i = 0; i < rows; i++) {
                res = Math.max(res, (rr[i] - ll[i] - 1) * left[i][j]);
            }
            //取最大值
        }
        return res;
    }

}
