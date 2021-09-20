package 程序员代码面试指南.栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 设计一个有getMin功能的栈
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class 设计一个有getMin功能的栈 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public 设计一个有getMin功能的栈() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
