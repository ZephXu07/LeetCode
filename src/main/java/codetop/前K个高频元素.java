package codetop;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title: 前K个高频元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-15
 */
public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(k+1, Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.offer(new int[]{e.getKey(), e.getValue()});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int inx = k - 1;
        while (!queue.isEmpty()) {
            res[inx--] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        前K个高频元素 res = new 前K个高频元素();
        int[] arr = res.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for (int n: arr) {
            System.out.print(n + "\t");
        }
    }
}
