package 剑指offer;

/**
 * Title: 反转链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 反转链表 {
//    public ListNode reverseList(ListNode head) {
//        if (null == head) {
//            return null;
//        }
//        if (null == head.next) {
//            return head;
//        }
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode tmp;
        ListNode pre = null;
        while (null != head) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
