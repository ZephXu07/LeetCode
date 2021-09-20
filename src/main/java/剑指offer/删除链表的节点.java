package 剑指offer;

/**
 * Title: 删除链表的节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (null == cur) {
            return head;
        }
        if (cur == head) {
            return head.next;
        }
        pre.next = cur.next;
        return head;
    }
}
