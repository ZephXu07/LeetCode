package 每日一题;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Title: 矩阵中战斗力最弱的K行
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-01
 */
public class 矩阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(k ,(i0, i1)-> {
            if (i0[1] != i1[1]) {
                return i1[1] - i0[1];
            }
            return i1[0] - i0[0];
        });
        for (int i = 0; i < mat.length; i++) {
            int[] tmp = new int[]{i, binaryRight(mat[i])};
            if (heap.size() == k && heap.peek()[1] > tmp[1] ){
                heap.poll();
            }
            if (heap.size() < k) {
                heap.offer(tmp);
            }
        }
        int[] res = new int[k];
        int inx = k - 1;
        while (!heap.isEmpty()) {
            res[inx] = heap.poll()[0];
            inx--;
        }
        return res;
    }

    private static int binaryRight (int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (arr[mid] == 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return arr[0] == 0 ? 0 : left + 1;
    }

    public static void main(String[] args) {
        矩阵中战斗力最弱的K行 res = new 矩阵中战斗力最弱的K行();
        int[][] mat = {{1,0},{0,0},{1,0}};
        int k = 2;
        System.out.println(Arrays.toString(res.kWeakestRows(mat, k)));
    }
}
