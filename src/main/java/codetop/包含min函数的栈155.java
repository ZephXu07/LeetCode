package codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Title: 包含min函数的栈155
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 包含min函数的栈155 {
}
class MinStack {

    private Deque<Integer> main;
    private Deque<Integer> auxiliary;
    /** initialize your data structure here. */
    public MinStack() {
        main = new LinkedList<>();
        auxiliary = new LinkedList<>();
    }

    public void push(int x) {
        main.push(x);
        if (auxiliary.isEmpty() || auxiliary.peek() >= x) {
            auxiliary.push(x);
        }
    }

    public void pop() {
        if (main.pop().equals(auxiliary.peek())) {
            auxiliary.pop();
        }
    }

    public int top() {
        return main.peek();
    }

    public int min() {
        return auxiliary.peek();
    }
}
