package codetop;

import 剑指offer.ListNode;

/**
 * Title: 给单链表加一
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 给单链表加一 {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode carry = dummy;
        /*
            它的下一个节点值为 9，万一需要进位
            例如 1099     carry 会指向 0
            而如果 1099009     carry 会指向右边第一个 0
            而如果 1099001     carry 会指向左边第一个0，但此时末尾不是9，需要进位，无所谓

         */
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != 9 && cur.next.val == 9) {
                carry = cur;
                /*
                    下一个为 9，做好进位的准备，此时链表尾端一定是9：1099009
                    如果不是9的话对进位没影响，可以忽略：1099001
                 */
            }
            cur = cur.next;
        }
        if (cur.val == 9) {
            /*
                末尾为9，carry 为从末尾9开始到左边第一个非9的
             */
            ListNode tmp = carry.next;
            while (tmp != null) {
                /*
                    carry后面全变为 0
                 */
                tmp.val = 0;
                tmp = tmp.next;
            }
            carry.val = carry.val + 1;
            /*
                carry 位自增1
             */
        } else {
            cur.val = cur.val + 1;
            /*
                末尾不是9，加一即可，无需进位
             */
        }
        return dummy.val == 0 ? dummy.next : dummy;
        /*
            可能不断进位，且原链表的第一个数字为9
            判断虚拟节点是否为1
            因为 carry 一开始指向虚拟节点，可以因此后面全为9
            进位了则是1，返回虚拟节点
            没进位则是0，返回虚拟节点的 Next 节点
         */
    }
}
