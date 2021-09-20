package 每日一题;

import java.util.Arrays;

/**
 * Title: 螺旋矩阵二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 */
public class 螺旋矩阵二 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int value = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = value;
                value++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[i][right] = value;
                value++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[bottom][i] = value;
                value++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[i][left] = value;
                value++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        螺旋矩阵二 res = new 螺旋矩阵二();
        int n = 3;
        System.out.println(Arrays.deepToString(res.generateMatrix(n)));
    }
}
