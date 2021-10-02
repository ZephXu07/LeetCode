package 剑指offer专项突击版;

import 剑指offer.ListNode;

/**
 * Title: 删除链表的倒数第n个结点021
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 删除链表的倒数第n个结点021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode first = node;
        ListNode second = node;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return node.next;
        /*
            |__________|_____|
                n         x
            |_____|__________|
               x        n

         */
    }
}
