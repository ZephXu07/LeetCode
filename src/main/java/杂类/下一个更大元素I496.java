package 杂类;

import java.util.*;

/**
 * Title: 下一个更大元素I496
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-15
 */
public class 下一个更大元素I496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        int len2 = nums2.length;
        int value;
        Map<Integer, Integer> map = new HashMap<>(len2);
        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            value = stack.isEmpty() ? -1 : stack.peek();
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
