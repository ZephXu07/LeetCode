package 字节;

import 剑指offer.ListNode;

/**
 * Title: 删除排序链表中的重复元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
