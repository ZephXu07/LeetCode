package 每日一题;

/**
 * Title: 重塑矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-17
 */
public class 重塑矩阵 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = count / col;
                int y = count % col;
                count++;
                res[i][j] = nums[x][y];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        重塑矩阵 res = new 重塑矩阵();
        int[][] nums = {{1,2,3,4}};
        int[][] reshape = res.matrixReshape(nums, 2, 2);
        for (int[] r: reshape){
            for (int i : r) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
