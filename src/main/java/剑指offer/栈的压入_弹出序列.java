package 剑指offer;

import java.util.*;

/**
 * Title: 栈的压入_弹出序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 栈的压入_弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int push : pushed) {
            stack.offer(push);
            while (!stack.isEmpty() && stack.peekLast() == popped[index]) {
                stack.removeLast();
                index++;
            }
        }
        return stack.isEmpty();
    }

    private List<String> res;
    public List<String> getAllStackValidSequences(int[] pushed) {
        res = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int p : pushed) {
            queue.offer(p);
        }
        Stack<Integer> stack = new Stack<>();

        StringBuilder builder = new StringBuilder();
        helper(queue, stack, builder);
        return res;
    }

    private void helper(LinkedList<Integer> queue, Stack<Integer> stack,
                        StringBuilder builder) {
        if (queue.isEmpty() && stack.isEmpty()) {
            res.add(builder.toString());
            builder.setLength(0);
            return;
        }
        if (!queue.isEmpty()) {
            int tmp = queue.poll();
            stack.push(tmp);
            helper(queue, stack, builder);
            stack.pop();
            queue.addFirst(tmp);
        }

        if (!stack.isEmpty()) {
            int tmp = stack.peek();
            StringBuilder sb = new StringBuilder(builder);
            sb.append(stack.pop()).append(' ');
            helper(queue, stack, sb);
            stack.push(tmp);

        }

    }

    public static void main(String[] args) {
        int[] pushed = {6,13,4,14,0,12,10,8,5,7,3,2,9,1,11};
        栈的压入_弹出序列 res = new 栈的压入_弹出序列();
        List<String> strings = res.getAllStackValidSequences(pushed);
        for (String s:strings) {
            System.out.println(s);
        }

    }
}
