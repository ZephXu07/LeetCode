package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 排序奇升偶降链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-26
 */
public class 排序奇升偶降链表 {
    public ListNode sortOddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode[] division = division(head);
        division[1] = reverse(division[1]);
        return merge(division);
    }

    private ListNode[] division (ListNode head) {
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
        odd.next = head;
        even.next = null;
        return new ListNode[]{oddFirst.next, evenFirst.next};
    }

    private ListNode reverse (ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode merge (ListNode[] heads) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode cur = pre;
        while (null != heads[0] && null != heads[1]) {
            if (heads[0].val > heads[1].val) {
                cur.next = heads[1];
                heads[1] = heads[1].next;
            } else {
                cur.next = heads[0];
                heads[0] = heads[0].next;
            }
            cur = cur.next;
        }
        if (null != heads[0]) {
            cur.next = heads[0];
        } else {
            cur.next = heads[1];
        }
        return pre.next;
    }


    public static void main(String[] args) {
        int[] arr = {1,8,3,6,5,4,7,2,9};
        ListNode list = 链表.getList(arr);
        排序奇升偶降链表 res = new 排序奇升偶降链表();
        list = res.sortOddEvenList(list);
        链表.toString(list);
    }

}
