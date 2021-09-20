package 程序员代码面试指南.栈和队列;

import java.util.Stack;

/**
 * Title: 如何仅用递归函数和栈操作逆序一个栈
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class 如何仅用递归函数和栈操作逆序一个栈 {
    public void reverseStackByRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int base = getBase(stack);
        reverseStackByRecursive(stack);
        stack.push(base);
    }

    private int getBase(Stack<Integer> stack) {
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        int base = getBase(stack);
        stack.push(top);
        return base;
    }


    public static void main(String[] args) {
        如何仅用递归函数和栈操作逆序一个栈 res = new 如何仅用递归函数和栈操作逆序一个栈();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        res.reverseStackByRecursive(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
