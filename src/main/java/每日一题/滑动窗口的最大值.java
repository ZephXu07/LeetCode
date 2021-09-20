package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 滑动窗口的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-02
 */
public class 滑动窗口的最大值 {
    class MonotonicQueue {
        private Deque<Integer> data = new LinkedList<>();

        public void push(int n) {
            while (0 != data.size() && data.peekLast() < n) {
                data.pollLast();
            }
            data.offerLast(n);
        }
        public int max() {
            return data.peekFirst();
        }

        public void pop(int n) {
            if (0 != data.size() && n == data.peekFirst()) {
                data.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                result[index++] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return result;
    }
}
