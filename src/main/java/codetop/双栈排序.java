package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 双栈排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-25
 */
public class 双栈排序 {

    public Deque<Integer> satckSort (Deque<Integer> stack) {
        Deque<Integer> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            int peek = stack.pop();
            while (!res.isEmpty() && res.peek() > peek) {
                stack.push(res.pop());
            }
            res.push(peek);
        }
        return res;
    }
}
