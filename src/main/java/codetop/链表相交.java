package codetop;

import 剑指offer.ListNode;

/**
 * Title: 链表相交
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (true) {
            if (p == q) {
                return p;
            }
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
    }
}
