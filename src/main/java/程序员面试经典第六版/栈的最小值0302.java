package 程序员面试经典第六版;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 栈的最小值0302
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 栈的最小值0302 {
}
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min.push(x);
        } else {
            assert !min.isEmpty();
            min.push(Math.min(x, min.peek()));
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        assert !min.isEmpty();
        min.pop();
        stack.pop();
    }

    public int top() {
        assert !stack.isEmpty();
        return stack.peek();
    }

    public int getMin() {
        assert !min.isEmpty();
        return min.peek();
    }
}
