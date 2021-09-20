package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 重排链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        ListNode[] listNodes = splitList(head);
        ListNode reverse = reverse(listNodes[1]);
        merge(head, reverse);
    }

    private ListNode[] splitList (ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        ListNode pre = slow;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (null != fast) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return new ListNode[] {list, slow};
    }

    private void merge (ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        ListNode res = l1;
        int count = 1;
        while (null != l1 || null != l2) {
            if ((count & 1) == 1) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            count++;
        }
    }

    private ListNode reverse (ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != head) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;

    }

    public static void main(String[] args) {
        重排链表 res = new 重排链表();
        int[] arr = {1,2,3,4};
        ListNode listNode = 链表.getList(arr);
        链表.toString(listNode);
        res.reorderList(listNode);
        链表.toString(listNode);
    }

}
