package 杂类;

import java.util.PriorityQueue;

/**
 * Title: 最接近原点的K个点973
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-03
 */
public class 最接近原点的K个点973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap =
                new PriorityQueue<>(k,
                        (a, b)-> b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
