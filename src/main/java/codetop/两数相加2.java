package codetop;

import 剑指offer.ListNode;
import 工具类.链表;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 两数相加2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-11
 */
public class 两数相加2 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverse(l1);
//        l2 = reverse(l2);
//        ListNode head = new ListNode(-1);
//        ListNode pre = head;
//        ListNode cur;
//        int c = 0;
//        while (l1 != null || l2 != null) {
//            int a = l1 == null ? 0 : l1.val;
//            int b = l2 == null ? 0 : l2.val;
//            int tmp = a + b + c;
//            c = tmp / 10;
//            cur = new ListNode(tmp % 10);
//            pre.next = cur;
//            pre = cur;
//            l1 = l1 == null ? null : l1.next;
//            l2 = l2 == null ? null : l2.next;
//        }
//        if (c != 0) {
//            cur = new ListNode(1);
//            pre.next = cur;
//        }
//        return reverse(head.next);
//    }
//
//    private ListNode reverse (ListNode list) {
//        ListNode cur = list;
//        ListNode pre = null;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int c = 0;
        ListNode head = new ListNode(-1);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;
            int tmp = a + b + c;
            ListNode node = new ListNode(tmp % 10);
            c = tmp / 10;
            ListNode next = head.next;
            head.next = node;
            node.next = next;
        }
        if (c != 0) {
            ListNode next = head.next;
            head.next = new ListNode(c);
            head.next.next = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        两数相加2 res = new 两数相加2();
//        ListNode l1 = 链表.getList(new int[]{7, 2, 4, 3});
//        ListNode l2 = 链表.getList(new int[]{5,6,4});
        ListNode l1 = 链表.getList(new int[]{2, 4, 3});
        ListNode l2 = 链表.getList(new int[]{5,6,4});
        链表.toString(res.addTwoNumbers(l1, l2));
    }
}
