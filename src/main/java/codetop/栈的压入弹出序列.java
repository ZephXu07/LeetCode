package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 栈的压入弹出序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int inx = 0;
        /*
            弹出数组的下标
         */
        for (int push : pushed) {
            stack.push(push);
            /*
                压栈
             */
            while (!stack.isEmpty() && stack.peek() == popped[inx]) {
                /*
                    当栈顶元素与弹出数组元素相同则弹出
                 */
                stack.pop();
                inx++;
                /*
                    下标自然增加
                 */
            }
        }
        return stack.isEmpty();
        /*
            遍历完压栈数组，如果还有剩余
            则说明弹出数组的某些值的顺序不符合压入的数组的顺序，
            不是压入数组的弹出数组
         */
    }
}
