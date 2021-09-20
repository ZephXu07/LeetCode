package 每日一题;

/**
 * Title: 矩形区域不超过K的最大数值和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-22
 */
public class 矩形区域不超过K的最大数值和 {

//    public static int maxSumSubmatrix0(int[][] matrix, int k) {
//        /*  看图
//            https://cdn.jsdelivr.net/gh/ZephXu07/newimages@master/20210422/zeph-Snipaste_2021-04-22_14-08-53.36sjt21wne00.png
//         */
//
//        int res = Integer.MIN_VALUE;
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[][] pre = new int[m + 1][n + 1];
//
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                pre[i][j] = pre[i - 1][j]
//                        + pre[i][j - 1]
//                        + matrix[i - 1][j - 1]
//                        - pre[i - 1][j - 1];
//
//            }
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                for (int p = i; p <= m; p++) {
//                    for (int q = j; q <= n; q++) {
//                        int tmp = pre[p][q] + pre[i - 1][j - 1] - pre[i - 1][q] - pre[p][j - 1];
//                        res = tmp <= k ? Math.max(tmp, res) : res;
//                    }
//                }
//            }
//        }
//        return res;
//
//
//    }

    public int maxSumSubmatrix0(int[][] matrix, int k) {
        /*
        https://leetcode-cn.com/
        problems/
        max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
            左边界固定，右边界不断扩大，rowSum数组中每一个值是当前左右边界中的和（包含边界），
            再在rowSum数组中寻找小于等于k的最大连续子数组
         */

        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) {
            // 枚举左边界
            int[] rowSum = new int[rows];
            // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) {
                // 枚举右边界
                for (int i = 0; i < rows; i++) {
                    // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }

                // 求 rowSum 连续子数组 的 和
                // 和 尽量大，但不大于 k
                max = Math.max(max, dpmax(rowSum, k));
            }
        }
        return max;
    }

    // 隔壁有完整代码
    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) {
                rollSum += arr[i];
            }
            else {
                rollSum = arr[i];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }
        //dp方法遍历，找到最大的连续子数组和
        if (rollMax <= k) {
            //此最大值 <= k，返回
            return rollMax;
        }
        // O(rows ^ 2)
        // > k，使用暴力
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k){
                    max = sum;
                }
                if (max == k){
                    return k;
                    // 尽量提前
                }
            }
        }
        return max;
    }




    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,0,1},
//                {0,-2,3}
//        };
//        int k = 2;
        //2
//        int[][] matrix = {
//                {2,2,-1}
//        };
//        int k = 3;
        //3
        int[][] matrix = {
                {5,-4,-3,4},
                {-3,-4,4,5},
                {5,1,5,-4}
        };
        int k = 8;
        //8
//        int[][] matrix = {
//                {2,2,-1}
//        };
//        int k = 0;
        //-1
//        int[][] matrix = {
//                {5,-4,-3,4},
//                {-3,-4,4,5},
//                {5,1,5,-4}
//        };
//        int k = 3;
        //2
        矩形区域不超过K的最大数值和 res = new 矩形区域不超过K的最大数值和();

        System.out.println(res.maxSumSubmatrix0(matrix, k));


    }



}
