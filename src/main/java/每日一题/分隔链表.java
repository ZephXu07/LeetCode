package 每日一题;

import 剑指offer.ListNode;
import 剑指offer.字符串构建链表;

/**
 * Title: 分隔链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-03
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(Integer.MIN_VALUE);
        ListNode s = small;
        ListNode big = new ListNode(Integer.MAX_VALUE);
        ListNode b = big;
        while (null != head) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                b.next = head;
                b = b.next;
            }
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        s.next = big.next;
        return small.next;
    }


    public static void main(String[] args) {
        ListNode list = new 字符串构建链表("143252").getList();
        分隔链表 res = new 分隔链表();
        list = res.partition(list, 3);
        while (null != list) {
            System.out.println(list.val + "\t");
            list = list.next;
        }
    }
}
