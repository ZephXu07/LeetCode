package 字节;

import 剑指offer.ListNode;

/**
 * Title: 相交链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-20
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (null == pA) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (null == pB) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
