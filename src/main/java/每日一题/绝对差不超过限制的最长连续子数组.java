package 每日一题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Title: 绝对差不超过限制的最长连续子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 绝对差不超过限制的最长连续子数组 {
    public int longestSubarrayTreeMap(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int res = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        while (right < nums.length) {
            int val = nums[right];
            window.put(val, window.getOrDefault(val, 0) + 1);
            right++;
            while (left <= right && window.lastKey() - window.firstKey() > limit) {
                int tmp = nums[left];
                int count = window.get(tmp);
                if (count - 1 == 0) {
                    window.remove(tmp);
                } else {
                    window.put(tmp, count - 1);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int res = 0;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        while (right < nums.length) {
            int val = nums[right];
            while (!max.isEmpty() && max.peekLast() < val) {
                max.pollLast();
            }
            max.offerLast(val);
            while (!min.isEmpty() && min.peekLast() > val) {
                min.pollLast();
            }
            min.offerLast(val);
            while (left <= right && max.peekFirst() - min.peekFirst() > limit) {
                int tmp = nums[left];
                if (tmp == max.peekFirst()) {
                    max.pollFirst();
                }
                if (tmp == min.peekFirst()) {
                    min.pollFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        绝对差不超过限制的最长连续子数组 res = new 绝对差不超过限制的最长连续子数组();
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(res.longestSubarray(nums, limit));
        System.out.println(res.longestSubarrayTreeMap(nums, limit));
    }
}
