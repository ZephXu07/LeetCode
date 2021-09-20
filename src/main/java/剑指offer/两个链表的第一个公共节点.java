package 剑指offer;

/**
 * Title: 两个链表的第一个公共节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aPtr = headA;
        ListNode bPtr = headB;
        while (aPtr != bPtr) {
            aPtr = (aPtr.next == null) ? headB : aPtr.next;
            bPtr = (bPtr.next == null) ? headA : bPtr.next;
        }
        return aPtr;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = a.next.next;
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        两个链表的第一个公共节点 res = new 两个链表的第一个公共节点();
        System.out.println(res.getIntersectionNode(a, b).val);
    }

}
