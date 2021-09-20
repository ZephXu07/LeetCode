package codetop;

import 剑指offer.ListNode;

/**
 * Title: 奇偶链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        /*
            当链表为空，或者链表只有一个节点，或者两个节点时都无需排序，直接返回
         */
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        ListNode oddFirst = new ListNode(Integer.MIN_VALUE);
        /*
            奇数节点虚拟头指针
         */
        ListNode odd = oddFirst;
        /*
            奇数节点遍历指针
         */
        ListNode evenFirst = new ListNode(Integer.MIN_VALUE);
        /*
            偶数节点虚拟头指针
         */
        ListNode even = evenFirst;
        /*
            偶数节点遍历指针
         */
        while (null != head && null != head.next) {
            /*
                奇偶节点同时存在
             */
            odd.next = head;
            /*
                连接奇节点
             */
            even.next = head.next;
            /*
                连接偶节点
             */
            head = head.next.next;
            /*
            下一对奇偶节点，head可能变成null
             */
            odd = odd.next;
            even = even.next;
        }
        if (null != head) {
            /*
                判断是不是还有一个奇节点
             */
            odd.next = head;
            odd = odd.next;
        }
        odd.next = evenFirst.next;
        even.next = null;
        /*
            奇偶链表连接，指针处理
         */
        return oddFirst.next;
    }
}
