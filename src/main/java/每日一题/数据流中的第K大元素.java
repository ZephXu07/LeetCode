package 每日一题;

import java.util.PriorityQueue;

/**
 * Title: 数据流中的第K大元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-11
 */
public class 数据流中的第K大元素 {
}
class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
