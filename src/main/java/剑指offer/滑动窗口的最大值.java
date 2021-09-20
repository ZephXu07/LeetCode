package 剑指offer;

import java.util.*;

/**
 * Title: 滑动窗口的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int right = 0;
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        MonotoneDecreasingQueue queue = new MonotoneDecreasingQueue();
        while (right < k - 1) {
            queue.addLast(nums[right]);
            right ++;
        }
        int left = 0;
        while (right < nums.length) {
            queue.addLast(nums[right]);
            ans[index++] = queue.getMax();
            queue.removeFirst(nums[left]);
            left ++;
            right ++;
        }
        return ans;
    }


    public static void main(String[] args) {
//        MonotoneDecreasingQueue queue = new MonotoneDecreasingQueue();
//        queue.addLast(1);
//        queue.addLast(3);
//        System.out.println(queue.getMax());
//        queue.removeFirst(1);
//        queue.addLast(2);
//        System.out.println(queue.getMax());
//        queue.removeFirst(3);
//        queue.addLast(0);
//        System.out.println(queue.getMax());
//        queue.removeFirst(1);
//        queue.addLast(5);
//        System.out.println(queue.getMax());

        滑动窗口的最大值 res = new 滑动窗口的最大值();
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(res.maxSlidingWindow(nums, k)));
    }
}
class MonotoneDecreasingQueue {
    private LinkedList<Integer> base;
    public MonotoneDecreasingQueue () {
        base = new LinkedList<>();
    }

    public void addLast (int value) {
        while (!base.isEmpty() && base.getLast() < value) {
            base.removeLast();
        }
        base.addLast(value);
    }

    public void removeFirst (int value) {
        if (!base.isEmpty() && base.getFirst() == value) {
            base.removeFirst();
        }
    }

    public int getMax () {
        return base.getFirst();
    }
}
