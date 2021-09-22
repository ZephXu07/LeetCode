package 每日一题;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 分隔链表725
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-22
 */
public class 分隔链表725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (null != head) {
            len++;
            head = head.next;
        }
        head = dummy.next;
        int avg = len / k;
        int leave = len % k;
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < leave; i++) {
            lists[i] = new ListNode(-1);
            int count = 0;
            ListNode cur = lists[i];
            while (count <= avg) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
                count++;
            }
            lists[i] = lists[i].next;
        }
        for (int i = leave; i < k; i++) {
            lists[i] = new ListNode(-1);
            int count = 0;
            ListNode cur = lists[i];
            while (count < avg) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
                count++;
            }
            cur.next = null;
            lists[i] = lists[i].next;
        }

        return lists;
    }

    public static void main(String[] args) {
        分隔链表725 res = new 分隔链表725();
        final ListNode list = 链表.getList(new int[]{1, 2, 3});
        final ListNode[] listNodes = res.splitListToParts(list, 3);
        for (ListNode l : listNodes) {
            链表.toString(l);
        }
    }
}
