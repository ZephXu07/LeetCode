package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 从尾到头打印链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 从尾到头打印链表 {
    /*private List<Integer> list = new LinkedList<>();
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return null;
        }
        reverse(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void reverse(ListNode head) {
        if (null == head) {
            return;
        }
        reverse(head.next);
        list.add(head.val);
    }*/

    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[]{};
        }
        int count = 1;
        ListNode node = head;
        while (null != node.next) {
            count ++;
            node = node.next;
        }
        System.out.println(count);
        int[] res = new int[count];
        node = head;
        while (null != node.next) {
            res[--count] = node.val;
            node = node.next;
        }
        res[0] = node.val;
        return res;
    }

}
