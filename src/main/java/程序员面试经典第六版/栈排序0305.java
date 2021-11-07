package 程序员面试经典第六版;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 栈排序0305
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 栈排序0305 {
}
class SortedStack {

    private Deque<Integer> stack;
    private Deque<Integer> tmp;
    public SortedStack() {
        stack = new LinkedList<>();
        tmp = new LinkedList<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tmp.push(stack.pop());
        }
        while (!tmp.isEmpty() && tmp.peek() > val) {
            stack.push(tmp.pop());
        }
        stack.push(val);
    }

    public void pop() {
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && tmp.isEmpty();
    }
}
