package 每日一题;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 移除链表元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-05
 */
public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        while (null != head) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;

        }
        return h.next;
    }

    public static void main(String[] args) {
        移除链表元素 res = new 移除链表元素();
        int[] arr = {1,2,6,3,4,5,6};
        int var = 6;
        ListNode list = 链表.getList(arr);
        链表.toString(list);
        list = res.removeElements(list, var);
        链表.toString(list);
    }
}
