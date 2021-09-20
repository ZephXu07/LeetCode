package codetop;

import java.util.LinkedList;

/**
 * Title: 队列的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-12
 */
public class 队列的最大值 {
}
class MaxQueue {
    /*
        一个队列 + 一个链表[first,last] 单调递减
        弹出最大则从链表处理
        进入队列则在链表中比较使单调递减
        出去队列则在队列出去，再对比出去的是不是链表第一个最大的
     */
    private LinkedList<Integer> main;
    private LinkedList<Integer> auxiliary;
    public MaxQueue() {
        main = new LinkedList<>();
        auxiliary = new LinkedList<>();
    }

    public int max_value() {
        if (auxiliary.isEmpty()) {
            return -1;
        }
        return auxiliary.getFirst();
    }

    public void push_back(int value) {
        while (!auxiliary.isEmpty() && auxiliary.getLast() < value) {
            auxiliary.removeLast();
        }
        main.addLast(value);
        auxiliary.addLast(value);
    }

    public int pop_front() {
        if (main.isEmpty()) {
            return -1;
        }
        int tmp = main.removeFirst();
        if (tmp == auxiliary.getFirst()) {
            auxiliary.removeFirst();
        }
        return tmp;
    }
}
