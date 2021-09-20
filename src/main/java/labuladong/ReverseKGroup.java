package labuladong;

/**
 * Title: labuladong.ReverseKGroup
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (null == b) {
                return head;
            }
            b = b.next;
        }
        ListNode last = reverseAtoB(a, b);
        last.next = reverseKGroup(b, k);
        return last;
    }

    private ListNode reverseAtoB(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode fol;
        while (b != cur) {
            fol= cur.next ;
            cur.next = pre;
            pre = cur;
            cur = fol;
        }
        return pre;
    }


}

