package 剑指offer;

/**
 * Title: 二维数组中的查找
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] curr = {0, column - 1};
        while (curr[0] < row && curr[1] >= 0) {
            if (matrix[curr[0]][curr[1]] == target) {
                return true;
            } else if (matrix[curr[0]][curr[1]] < target) {
                curr[0] ++;
//                curr[1] = column - 1;
            } else if (matrix[curr[0]][curr[1]] > target) {
                curr[1] --;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{-5}};
        int target = -5;
//        int target = 5;
        二维数组中的查找 二维数组中的查找 = new 二维数组中的查找();
        boolean b = 二维数组中的查找.findNumberIn2DArray(matrix, target);
        System.out.println(b);
    }
}


