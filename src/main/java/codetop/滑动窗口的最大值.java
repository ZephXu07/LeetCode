package codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Title: 滑动窗口的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0 || len < k) {
            /*
                特殊情况 ，直接返回
             */
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            /*
                预先填充 k 个数字
             */
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                /*
                    使队列里的数字都严格单调递减
                 */
                deque.removeLast();
            }
            deque.addLast(i);
        }
        int[] res = new int[len - k + 1];
        /*
            长度为 len 的数组可以被 k 长度的窗口划分
         */
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < len; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {

                deque.removeLast();
            }
            deque.addLast(i);
            /*
                    继续添加，使队列里单调递减
            */
            while (!deque.isEmpty() && deque.peekFirst() + k <= i) {
                /*
                    检查队列里的下标，在新窗口外的移除

                 */
                deque.removeFirst();
            }
            /*
                当移除完不符合的下标的，剩下的单调递减，在队列首部的即是最大的元素的下标
                ide提示空指针但实际不会，因为队列是单调递减的即使在前面因为抛出了不单调递减的
                还有最新放入的值，同理最新放入的值是不会超出窗口的
                在 res 的下标则由 i - k + 1 计算出
             */
            res[i - k + 1] = nums[deque.peekFirst()];
        }

        return res;
    }
}
