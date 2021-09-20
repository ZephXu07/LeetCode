package codetop;

import 剑指offer.ListNode;

/**
 * Title: 链表求和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (null != l1 || null != l2) {
            int a = 0;
            if (null != l1) {
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if (null != l2) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
