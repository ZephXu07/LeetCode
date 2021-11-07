package 程序员面试经典第六版;

import 剑指offer.ListNode;

/**
 * Title: 回文链表0206
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 回文链表0206 {
    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode p = head;
        ListNode rev = reverse(slow.next);
        ListNode q = rev;

        boolean res = true;
        while (res && null != p && null != q) {
            if (p.val != q.val) {
                res = false;
            }
            p = p.next;
            q = q.next;
        }

        slow.next = reverse(rev);
        return res;
    }


    private ListNode reverse (ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
