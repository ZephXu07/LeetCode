package 字节;

/**
 * Title: 旋转图像
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 旋转图像 {
//    public void rotate(int[][] matrix) {
//        //四个点互相旋转
//        int n = matrix.length;
//        for (int i = 0; i < (n + 1) / 2; i ++) {
//            for (int j = 0; j < n / 2; j++) {
//                int temp = matrix[n - 1 - j][i];
//                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
//                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
//                matrix[j][n - 1 - i] = matrix[i][j];
//                matrix[i][j] = temp;
//            }
//        }
//    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //上下翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = tmp;
            }
        }
        //对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //两个翻转相当于方法一四个数字翻转
    }
    
}
