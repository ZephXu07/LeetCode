package 程序员面试经典第六版;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 化栈为队0304
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 化栈为队0304 {
}
class MyQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;
    public MyQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void push(int x) {
        left.push(x);
    }

    public int pop() {
        balance();
        return right.pop();
    }

    public int peek() {
        balance();
        assert !right.isEmpty();
        return right.peek();
    }

    private void balance () {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}
