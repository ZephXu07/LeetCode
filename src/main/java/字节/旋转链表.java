package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 旋转链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-22
 */
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        int len = 0;
        while (null != head) {
            len++;
            head = head.next;
        }
        if (len == 1) {
            return first.next;
        }
        k %= len;
        if (k == 0) {
            return first.next;
        }
        int start = len;
        head = first.next;
        ListNode pre = head;
        while (start != k) {
            pre = head;
            head = head.next;
            start--;
        }
        pre.next = null;
        ListNode newHead = head;
        head = first.next;
        first.next = newHead;
        while (null != newHead) {
            pre = newHead;
            newHead = newHead.next;
        }
        pre.next = head;
        return first.next;
    }

    public static void main(String[] args) {
        旋转链表 res = new 旋转链表();
        int[] arr = {1,2};
        ListNode list = 链表.getList(arr);
        链表.toString(list);
        int k = 2;
        System.out.println("------------");
        链表.toString(res.rotateRight(list, k));
    }

}
