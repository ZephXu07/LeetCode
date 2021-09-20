package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 最大矩形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-26
 */
public class 最大矩形 {
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
        int res = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == '0') {
//                    continue;
//                }
//                int wid = left[i][j];
//                int area = wid;
//                for (int k = i - 1; k >= 0; k--) {
//                    wid = Math.min(wid, left[k][j]);
//                    area = Math.max(area, (i - k + 1) * wid);
//                }
//                res = Math.max(area, res);
//            }
//        }

        for (int j = 0; j < cols; j++) {
            int[] up = new int[rows];
            int[] down = new int[rows];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();
            for (int i = rows - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? rows : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < rows; i++) {
                res = Math.max((down[i] - up[i] - 1) * left[i][j], res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        最大矩形 res = new 最大矩形();
        char[][] matrix = {{'2','1','5','6','2','3'}};
        System.out.println(res.maximalRectangle(matrix));

    }
}
