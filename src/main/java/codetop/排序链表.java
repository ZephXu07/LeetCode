package codetop;

import 剑指offer.ListNode;
import 工具类.链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: 排序链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-10
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort (ListNode head, ListNode tail) {
        if (null == head) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode head1 = sort(head, slow);
        ListNode head2 = sort(slow, tail);
        return merge(head1, head2);
    }


    private ListNode sort (ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (null != cur) {
            len++;
            cur = cur.next;
        }
        /*
            得到链表长度
         */

        /*
                4 2
                2 4

                4   2   1
                2 4    1
                1 2 4

                4   2    1   3
                2 4     1 3
                1 2 3 4

                4    2   1   3   0
                2 4     1 3     0
                1 2 3 4     0
                0 1 2 3 4

                以此类推
                1  2  4  8  ......
             */
        ListNode dummy = new ListNode(100001, head);
        for (int sub = 1; sub < len; sub *= 2) {
            cur = dummy.next;
            ListNode pre = dummy;

            while (null != cur) {
                /*
                    把整个链表分为 n 段长度为 sub 的部分，再每两部分排序
                 */
                ListNode head1 = cur;
                for (int i = 1; i < sub && cur.next != null; i++) {
                    cur = cur.next;
                }
                /*
                    第一部分
                 */

                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                /*
                    断开连接
                 */

                for (int i = 1; i < sub && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                /*
                    第二部分
                 */

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                /*
                        判断是否还有
                 */

                pre.next = merge(head1, head2);
                while (null != pre.next) {
                    pre = pre.next;
                }
                cur = next;
                /*
                    连接已经排好序的
                 */
            }

        }
        return dummy.next;
    }

    private ListNode merge (ListNode head1, ListNode head2) {
        ListNode pre = new ListNode(100001);
        ListNode cur = pre;
        while (null != head1 && null != head2) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (null != head1) {
            cur.next = head1;
        } else if (null != head2) {
            cur.next = head2;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        排序链表 res = new 排序链表();
        int[] arr = {4,2,1,5,9};
        ListNode head = 链表.getList(arr);
        链表.toString(head);
        head = res.sortList(head);
        链表.toString(head);
    }

}
