package codetop;

/**
 * Title: 设计循环队列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-26
 */
public class 设计循环队列 {
}
class MyCircularQueue {

    private int[] array;
    private int head;
    private int count;
    private int tail;
    private int len;

    public MyCircularQueue(int k) {
        array = new int[k];
        head = -1;
        len = k;
        count = 0;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (count == len) {
            return false;
        }
        if (count == 0) {
            array[0] = value;
            head = 0;
            tail = 0;
        } else {
            tail = (tail + 1) % len;
            array[tail] = value;

        }
        count++;
        return true;

    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (count == 1) {
            head = -1;
            tail = -1;
            count = 0;
        } else {
            head = (head + 1) % len;
            count--;
        }

        return true;
    }

    public int Front() {
        return head == -1 ? -1 : array[head];
    }

    public int Rear() {
        return tail == -1 ? -1 : array[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == len;
    }
}
