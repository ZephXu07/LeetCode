package 程序员面试经典第六版;

import 剑指offer.ListNode;

/**
 * Title: 删除中间节点0203
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-05
 */
public class 删除中间节点0203 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
