package 字节;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 每日温度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int len = T.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        每日温度 res = new 每日温度();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = res.dailyTemperatures(T);
        System.out.println(Arrays.toString(ints));
    }
}
