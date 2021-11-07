package 程序员面试经典第六版;

import 剑指offer.ListNode;

/**
 * Title: 返回倒数第k个节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-05
 */
public class 返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
