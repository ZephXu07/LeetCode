package 剑指offer专项突击版;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 矩阵中最大的矩形040
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 矩阵中最大的矩形040 {
    public int maximalRectangle(String[] tmp) {
        if (0 == tmp.length) {
            return 0;
        }
        char[][] matrix = new char[tmp.length][];
        for (int i = 0; i < tmp.length; i++) {
            matrix[i] = tmp[i].toCharArray();
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
