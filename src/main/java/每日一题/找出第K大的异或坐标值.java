package 每日一题;

import labuladong.Solution;

import java.util.*;

/**
 * Title: 找出第K大的异或坐标值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-19
 */
public class 找出第K大的异或坐标值 {

    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] pre = new int[row + 1][col + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        //默认小根堆，顶部是最小的，在k容量下是第 k 大的
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (queue.size() < k) {
                    queue.offer(pre[i][j]);
                    //容量小于时直接添加
                } else {
                    if (queue.peek() < pre[i][j]) {

                        //已经满了，此时顶部比新添加的还小，代替第 k 大
                        queue.poll();
                        queue.offer(pre[i][j]);
                    }
                }
            }
        }
        return queue.peek();

    }




    public static void main(String[] args) {
        找出第K大的异或坐标值 res = new 找出第K大的异或坐标值();
//        int[][] matrix = {  {5, 2},
//                            {1, 6}
//                        };
        int[][] matrix = {{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
        int k = 10;
        System.out.println(res.kthLargestValue(matrix, k));
    }

}
