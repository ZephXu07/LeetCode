package 程序员面试经典第六版;

import 剑指offer.ListNode;

/**
 * Title: 环路检测0208
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 环路检测0208 {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean res = false;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                res = true;
                break;
            }
        }
        if (!res) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
