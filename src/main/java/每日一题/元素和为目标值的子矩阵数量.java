package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 元素和为目标值的子矩阵数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-29
 */
public class 元素和为目标值的子矩阵数量 {
    public int numSubmatrixSumTargetOn4(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] pre = new int[row + 1][col + 1];

        int res = 0;
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= row; i++) {
             for (int j = 1; j <= col; j++) {
                 for (int p = i; p <= row; p++) {
                     for (int q = j; q <= col; q++) {
                         int tmp = pre[p][q] + pre[i - 1][j - 1] - pre[i - 1][q] - pre[p][j - 1];
                         if (tmp == target) {
                             res++;
                         }
                     }
                 }
             }
        }
        return res;
    }


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        /*
        https://leetcode-cn.com/
        problems/
        max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
            左边界固定，右边界不断扩大，rowSum数组中每一个值是当前左右边界中的和（包含边界），
            再在rowSum数组中寻找小于等于k的最大连续子数组
         */

        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
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
                res += findTarget(rowSum, target);
            }
        }
        return res;
    }


    // 在数组 arr 中，求和为 k 的连续子数组
    private int findTarget(int[] arr, int target) {
        /*
            此处可用前缀和数组来进行，如

            int len = arr.length;
            int[] pre = new int[len + 1];
            pre[0] = 0;
            for (int i = 0; i < len; i++) {
                pre[i + 1] = pre[i] + arr[i];
            }
            int res = 0;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    if (pre[i] - pre[j] == k) {
                        res ++;
                    }
                }
            }
            return res;

            此处的条件是 pre[i] - pre[j] == k
                0 <= i < len
                0 <= j < i

            即可用map将前面计算的pre前缀和存储，再用map进行线性查找
            map.put(0, 1); 是为了代替 pre[0] = 0


         */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : arr) {
            pre += x;
            if (map.containsKey(pre - target)) {
                count += map.get(pre - target);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        元素和为目标值的子矩阵数量 res = new 元素和为目标值的子矩阵数量();
        int[][] matrix = {
                {0,1,0},
                {1,1,1},
                {0,1,0}};
        int target = 0;
        System.out.println(res.numSubmatrixSumTargetOn4(matrix, target));
        System.out.println(res.numSubmatrixSumTarget(matrix, target));


        System.out.println("-------------------");


//        int[] arr = {0,1,0};
        int[] arr = {0,1,1};
        System.out.println(res.findTarget(arr, 0));

    }
}
