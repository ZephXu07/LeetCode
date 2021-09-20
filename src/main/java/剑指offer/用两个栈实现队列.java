package 剑指offer;

import java.util.Stack;

public class 用两个栈实现队列 {
    private Stack<Integer> left;
    private Stack<Integer> right;
    public 用两个栈实现队列() {
        left = new Stack<>();
        right = new Stack<>();
    }
    
    public void appendTail(int value) {
        right.push(value);
    }
    
    public int deleteHead() {
        if (left.empty()) {
            while (!right.empty()) {
                left.push(right.pop());
            }
        }
        return left.empty() ? -1 : left.pop();
    }


    public static void main(String[] args) {
        用两个栈实现队列 queue = new 用两个栈实现队列();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}