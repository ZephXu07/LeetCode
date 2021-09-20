package 剑指offer;

import java.util.PriorityQueue;

/**
 * Title: 数据流中的中位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 数据流中的中位数 {

}
class MedianFinder {
    private PriorityQueue<Integer> triangle;
    private PriorityQueue<Integer> trapezoidal;

    /** initialize your data structure here. */
    public MedianFinder() {
        triangle = new PriorityQueue<>();
        trapezoidal = new PriorityQueue<>((i1, i2) -> i2-i1);
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
            return (triangle.peek() + trapezoidal.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> trapezoidal = new PriorityQueue<>();
        trapezoidal.add(1);
        trapezoidal.add(12);
        trapezoidal.add(14);
        while (!trapezoidal.isEmpty()) {
            System.out.println(trapezoidal.poll());
        }
    }
}