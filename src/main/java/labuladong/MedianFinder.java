package labuladong;

import java.util.PriorityQueue;

/**
 * Title: labuladong.MedianFinder
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-23
 */
public class MedianFinder {
    private PriorityQueue<Integer> triangle;
    private PriorityQueue<Integer> trapezoidal;

    /** initialize your data structure here. */
    public MedianFinder() {
        triangle = new PriorityQueue<>((a, b) -> b - a);
        trapezoidal = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (triangle.size() >= trapezoidal.size()) {
            triangle.offer(num);
            trapezoidal.offer(triangle.poll());
        } else {
            trapezoidal.offer(num);
            triangle.offer(trapezoidal.poll());
        }
    }

    public double findMedian() {
        if (triangle.size() > trapezoidal.size()) {
            return triangle.peek();
        } else if (triangle.size() < trapezoidal.size()) {
            return trapezoidal.peek();
        } else {
            return (triangle.peek() + trapezoidal.peek() ) / 2.0;
        }
    }
}
