package 剑指offer专项突击版;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 最近请求次数042
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 最近请求次数042 {
}
class RecentCounter {

    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();

    }
}
