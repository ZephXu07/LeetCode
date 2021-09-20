package labuladong;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Title: labuladong.NextGreaterElement
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int len2 = nums2.length;
        int value;
        Map<Integer, Integer> map = new HashMap<>(len2);
        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            value = stack.empty() ? -1 : stack.peek();
            map.put(nums2[i], value);
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
