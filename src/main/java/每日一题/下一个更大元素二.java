package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 下一个更大元素二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-06
 */
public class 下一个更大元素二 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        int inx;
        for (int i = 2 * len - 1; i >= 0; i--) {
            inx = i % len;
            while (!stack.isEmpty() && stack.peek() <= nums[inx]) {
                stack.pop();
            }
            res[inx] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[inx]);
        }
        return res;
    }
}
