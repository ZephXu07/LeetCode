package 每日一题;

import 剑指offer.ListNode;

import java.util.List;

/**
 * Title: 反转链表二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-18
 */
public class 反转链表二 {
//    private ListNode successor = null;
//    // 后驱节点
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (m == 1) {
//            return reverseN(head, n);
//        }
//        head.next = reverseBetween(head.next, m - 1, n - 1);
//        return head;
//    }
//
//    private ListNode reverseN(ListNode head, int n) {
//        if (n == 1) {
//            successor = head.next;
//            return head;
//        }
//        ListNode last = reverseN(head.next, n - 1);
//        head.next.next = head;
//        head.next = successor;
//        return last;
//    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = m; i < n; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        反转链表二 res = new 反转链表二();
        int[] arr = {9,7,2,5,4,3,6};
        ListNode list = res.getList(arr);
        System.out.println(res.toString(list));
        list = res.reverseBetween(list, 3, 6);
        System.out.println(res.toString(list));
    }

    public ListNode getList(int[] arr) {
        ListNode first = new ListNode(-1);
        ListNode pre = first;
        for (int j : arr) {
            pre.next = new ListNode(j);
            pre = pre.next;
        }
        return first.next;
    }

    public String toString(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        while (null != listNode) {
            builder.append(listNode.val).append("-->");
            listNode = listNode.next;
        }
        return builder.toString();
    }

}
