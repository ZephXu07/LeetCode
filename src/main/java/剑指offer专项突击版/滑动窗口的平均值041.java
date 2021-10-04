package 剑指offer专项突击版;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 滑动窗口的平均值041
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 滑动窗口的平均值041 {
}
class MovingAverage {

    private Deque<Integer> deque;
    private int size;
    private double sum;
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (deque.size() == size) {
            sum -= deque.removeFirst();
        }
        sum += val;
        deque.addLast(val);
        return sum / deque.size();
    }
}
