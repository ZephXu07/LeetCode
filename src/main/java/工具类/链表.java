package 工具类;

import 剑指offer.ListNode;

/**
 * Title: 链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-18
 */
public class 链表 {
    public static ListNode getList(int[] arr) {
        ListNode first = new ListNode(-1);
        ListNode pre = first;
        for (int j : arr) {
            pre.next = new ListNode(j);
            pre = pre.next;
        }
        return first.next;
    }

    public static ListNode reverse(ListNode list) {
        ListNode cur = list;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void toString(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        while (null != listNode) {
            builder.append(listNode.val);
            listNode = listNode.next;
            if (null != listNode) {
                builder.append(" --> ");
            }
        }
        System.out.println(builder);
    }


    public static void main(String[] args) {
        ListNode list = getList(new int[]{7,2,4,3});
        toString(list);
        list = reverse(list);
        toString(list);
    }
}
