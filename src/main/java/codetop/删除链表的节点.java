package codetop;

import 剑指offer.ListNode;

/**
 * Title: 删除链表的节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;


        while (null != cur.next && cur.next.val != val) {
            cur = cur.next;
        }

        if (null == cur.next) {
            return dummy.next;
        } else {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = null;
        }

        return dummy.next;

    }
}
