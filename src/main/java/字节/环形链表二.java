package 字节;

import 剑指offer.ListNode;

/**
 * Title: 环形链表二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 环形链表二 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (null == fast || null == fast.next) {
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
