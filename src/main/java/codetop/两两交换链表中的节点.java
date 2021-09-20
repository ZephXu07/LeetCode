package codetop;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 两两交换链表中的节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode fast = head.next;
        ListNode slow = head;

        while (null != fast && null != slow) {
            pre.next = fast;
            slow.next = fast.next;
            fast.next = slow;

            pre = slow;
            slow = slow.next;
            if (null != slow) {
                fast = slow.next;
            }
        }

        return fake.next;
    }


    public static void main(String[] args) {
        两两交换链表中的节点 res = new 两两交换链表中的节点();
//        int[] arr = {1,2,3,4};
//        int[] arr = {};
        int[] arr = {1};
        ListNode list = 链表.getList(arr);
        ListNode swap = res.swapPairs(list);
        链表.toString(swap);
    }

}
