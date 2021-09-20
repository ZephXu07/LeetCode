package 字节;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Title: 用两个栈实现队列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 用两个栈实现队列 {
}
class CQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;
    public CQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void appendTail(int value) {
        right.push(value);
    }

    public int deleteHead() {
        if (left.isEmpty()) {
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
        }
        return left.isEmpty() ? -1 : left.pop();
    }
}