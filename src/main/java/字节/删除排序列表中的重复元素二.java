package 字节;

import 剑指offer.ListNode;
import 工具类.链表;

/**
 * Title: 删除排序列表中的重复元素二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-18
 */
public class 删除排序列表中的重复元素二 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode first = new ListNode(Integer.MIN_VALUE);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        int tmp = head.val;
        while (null != cur && null != cur.next) {
            if (cur.val == cur.next.val) {
                while (null != cur.next && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }


    public static void main(String[] args) {
//        int[] arr = {1,2,3,3,4,4,5};
        int[] arr = {1,1,1,2,3};
        ListNode list = 链表.getList(arr);
        链表.toString(list);
        删除排序列表中的重复元素二 res = new 删除排序列表中的重复元素二();
        ListNode list1 = res.deleteDuplicates(list);
        链表.toString(list1);
    }
}
