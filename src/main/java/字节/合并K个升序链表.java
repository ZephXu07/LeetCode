package 字节;

import 剑指offer.ListNode;

import java.util.PriorityQueue;

/**
 * Title: 合并K个升序链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-25
 */
public class 合并K个升序链表 {
    public ListNode mergeKListsWaysOne(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeKListsWaysTwo(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }




    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (null != l1 && null != l2) {
            if (l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeKListsWaysThree(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1,l2)->l1.val - l2.val);
        for (ListNode l : lists) {
            while (null != l) {
                queue.offer(l);
                l = l.next;
            }
        }
        ListNode head = new ListNode(10001);
        ListNode cur = head;
        ListNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            cur.next = tmp;
            cur = tmp;
            if (queue.isEmpty()) {
                cur.next = null;
            }
        }
        return head.next;
    }
}
