package 剑指offer;

import java.util.Stack;

/**
 * Title: 包含min函数的栈
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 包含min函数的栈 {

}
class MinStack {

    private Stack<Integer> main;
    private Stack<Integer> auxiliary;
    /** initialize your data structure here. */
    public MinStack() {
        main = new Stack<>();
        auxiliary = new Stack<>();
    }

    public void push(int x) {
        main.add(x);
        if (auxiliary.empty() || auxiliary.peek() >= x) {
            auxiliary.add(x);
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