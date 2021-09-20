package codetop;

import 剑指offer.ListNode;
import 工具类.链表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 移除重复节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 移除重复节点 {
//    public ListNode removeDuplicateNodes(ListNode head) {
//        Set<Integer> set = new HashSet<>();
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (null != head) {
//            if (!set.contains(head.val)) {
//                cur.next = head;
//                cur = cur.next;
//                set.add(head.val);
//            }
//            head = head.next;
//
//        }
//        cur.next = null;
//        return dummy.next;
//    }
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (null != head) {
            ListNode tmp = head;
            while (null != tmp.next) {
                if (tmp.next.val == head.val) {
                    tmp.next = tmp.next.next;
                } else {
                    tmp = tmp.next;
                }
            }
            cur.next = head;
            cur = cur.next;
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        final ListNode list = 链表.getList(new int[]{1, 2, 3, 3, 2, 1});
        移除重复节点 res = new 移除重复节点();
        final ListNode listNode = res.removeDuplicateNodes(list);
        链表.toString(listNode);
    }
}
