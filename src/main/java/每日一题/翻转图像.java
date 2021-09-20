package 每日一题;

import java.util.Arrays;

/**
 * Title: 翻转图像
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-24
 */
public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (col + 1) / 2; j++) {
                //col+1可以使奇数时中间数翻转，且不用多余判断
                if (A[i][j] == A[i][col - j - 1]) {
                    int tmp = A[i][j] ^ 1;
                    A[i][j] = A[i][col - j - 1] ^ 1;
                    A[i][col - j - 1] = tmp;
                    //相等时才需要翻转，减少翻转量
                }
            }

        }
        return A;
    }

    public static void main(String[] args) {
        翻转图像 res = new 翻转图像();
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(res.flipAndInvertImage(A)));
    }
}
