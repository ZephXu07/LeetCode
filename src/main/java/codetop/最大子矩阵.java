package codetop;

/**
 * Title: 最大子矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-28
 */
public class 最大子矩阵 {
    public int[] getMaxMatrix(int[][] matrix) {
        /*
            二维转化为一维数组的最大子序和
            0 <= i < row
            固定 i 开始，row - 1结束
            每列的和用一个数组对应列下标存储起来

            在 i 固定时列从 0 -> col - 1

            由一维dp可知 sum <= 0，nums[i] 是新的开始
            二维同理，此时 nums[i] 是 b[i]
            记录了 i ->  row-1 的每一列的总和
            且每次固定的 i 变化则重新归 0

         */
        int row = matrix.length;
        int col = matrix[0].length;


        int startRow = 0;
        int startCol = 0;

        int sum;
        int max = Integer.MIN_VALUE;

        int[] res = new int[4];
        for (int i = 0; i < row; i++) {
            int[] b = new int[col];
            for (int k = i; k < row; k++) {
                sum = 0;
                for (int l = 0; l < col; l++) {
                    b[l] += matrix[k][l];
                    /*
                        记录 i 开始到 row -1 的一列，两列...的值

                     */
                    if (sum > 0) {
                        /*
                            已经化为一维的 dp 子序和
                         */
                        sum += b[l];
                    } else {
                        sum = b[l];
                        /*
                            由一维知道此处是新的才会有更大的值
                         */
                        startRow = i;
                        /*
                            因为 b[l] 是从 i 累积的，所以起点行是 i ，列自然是 l
                         */
                        startCol = l;

                    }

                    if (sum > max) {
                        /*
                            进行比较与存储
                         */
                        max = sum;
                        res[0] = startRow;
                        res[1] = startCol;
                        res[2] = k;
                        res[3] = l;
                    }
                }
            }
        }
        return res;

    }
}
