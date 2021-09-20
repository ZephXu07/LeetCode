package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 奇偶链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-26
 */
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode oddFirst = new ListNode(Integer.MIN_VALUE);
        ListNode odd = oddFirst;
        ListNode evenFirst = new ListNode(Integer.MIN_VALUE);
        ListNode even = evenFirst;
        while (null != head && null != head.next) {
            odd.next = head;
            even.next = head.next;
            if (head.val == 2) {
                System.out.println();
            }
            head = head.next.next;
            odd = odd.next;
            even = even.next;
        }
        if (null != head) {
            odd.next = head;
            odd = odd.next;
        }
        odd.next = evenFirst.next;
        even.next = null;
        return oddFirst.next;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode list = 链表.getList(arr);
        奇偶链表 res = new 奇偶链表();
        list = res.oddEvenList(list);
        链表.toString(list);
    }

}
