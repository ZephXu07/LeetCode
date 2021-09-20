package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 两数相加
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int sum = 0;
        int val = 0;
        int carry = 0;
        ListNode cur = head;
        head.next = cur;
        while (null !=l1 || null != l2) {
            if (null == l1) {
                sum = carry + l2.val;
            } else if (null == l2){
                sum = carry + l1.val;
            } else {
                sum = l1.val + l2.val + carry;
            }
            val = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {9,9,9,9,9,9,9};
        int[] nums2 = {9,9,9,9};
        ListNode list1 = 链表.getList(nums1);
        ListNode list2 = 链表.getList(nums2);
        链表.toString(list1);
        链表.toString(list2);
        两数相加 res = new 两数相加();
        ListNode listNode = res.addTwoNumbers(list1, list2);
        链表.toString(listNode);
    }
}
