package 每日一题;

/**
 * Title: 搜索二维矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-30
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        if (m == 1 && n == 1) {
//            return matrix[0][0] == target;
//        }
//        int low = 0;
//        int high = m - 1;
//        int mid;
//        while (low < high) {
//            mid = (low + high) / 2;
//            if (matrix[mid][n - 1] < target) {
//                low = mid + 1;
//            } else if (matrix[mid][n - 1] > target) {
//                if (matrix[mid][0] < target) {
//                    low = mid;
//                    break;
//                }
//                high = mid;
//            } else {
//                return true;
//            }
//        }
//        int row = low;
//        low = 0;
//        high = n - 1;
//        while (low <= high) {
//            mid = low + (high - low) / 2;
//            if (matrix[row][mid] < target) {
//                low = mid + 1;
//            } else if (matrix[row][mid] > target) {
//                high = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;


        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        //0下标开始，于是 -1
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            //避免溢出
            int x = matrix[mid / n][mid % n];
            //mid / n 得到行数
            //mid % n 得到列数
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
            //正常的二分查找
        }
        return false;
    }


    public static void main(String[] args) {
        搜索二维矩阵 res = new 搜索二维矩阵();
        int[][] matrix = {{1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}};
//        int[][] matrix = {{1,2,3,8}};
        int target = 13;
        System.out.println(target + "\t\t" + res.searchMatrix(matrix, target));
    }
}

