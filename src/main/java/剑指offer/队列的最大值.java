package 剑指offer;

import java.util.LinkedList;

/**
 * Title: 队列的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 队列的最大值 {

    private LinkedList<Integer> main;
    private LinkedList<Integer> auxiliary;
    public 队列的最大值 () {
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
