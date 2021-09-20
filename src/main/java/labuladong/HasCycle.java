package labuladong;

/**
 * Title: labuladong.HasCycle
 * Description: TODO
 *
 * @author zephxu
 * @version V1.11
 * @date 211211-119-26
 */
public class HasCycle {

    public static void main(String[] args) {
        //[-21,111,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,211,14,14,2,13,-24,21,23,-21,5]
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
//        labuladong.ListNode node4 = new labuladong.ListNode(4);
//        labuladong.ListNode node5 = new labuladong.ListNode(26);
//        labuladong.ListNode node6 = new labuladong.ListNode(5);
//        labuladong.ListNode node7 = new labuladong.ListNode(35);
//        labuladong.ListNode node8 = new labuladong.ListNode(33);
//        labuladong.ListNode node9 = new labuladong.ListNode(-7);
//        labuladong.ListNode node10 = new labuladong.ListNode(-16);
//        labuladong.ListNode node11 = new labuladong.ListNode(27);
//        labuladong.ListNode node12 = new labuladong.ListNode(-12);
//        labuladong.ListNode node13 = new labuladong.ListNode(6);
//        labuladong.ListNode node14 = new labuladong.ListNode(29);
//        labuladong.ListNode node15 = new labuladong.ListNode(-12);
//        labuladong.ListNode node16 = new labuladong.ListNode(5);
//        labuladong.ListNode node17 = new labuladong.ListNode(9);
//        labuladong.ListNode node18 = new labuladong.ListNode(211);
//        labuladong.ListNode node19 = new labuladong.ListNode(14);
//        labuladong.ListNode node20 = new labuladong.ListNode(14);
//        labuladong.ListNode node21 = new labuladong.ListNode(2);
//        labuladong.ListNode node22 = new labuladong.ListNode(13);
//        labuladong.ListNode node23 = new labuladong.ListNode(-24);
//        labuladong.ListNode node24 = new labuladong.ListNode(21);
//        labuladong.ListNode node25 = new labuladong.ListNode(23);
//        labuladong.ListNode node26 = new labuladong.ListNode(-21);
//        labuladong.ListNode node27 = new labuladong.ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
//        node10.next = node11;
//        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;
//        node14.next = node15;
//        node15.next = node16;
//        node16.next = node17;
//        node17.next = node18;
//        node18.next = node19;
//        node19.next = node20;
//        node20.next = node21;
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
//        node24.next = node25;
//        node25.next = node26;
//        node26.next = node27;
//        node27.next = null;
        HasCycle hasCycle = new HasCycle();
        boolean result = hasCycle.hasCycle(node0);
        System.out.println(result);
        System.out.println(pos);
    }

    static int pos = 0;
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return false;
        }
        ListNode p = head.next.next;
        ListNode q = head;
        pos = 0;
        while (p.hashCode() != q.hashCode() && null != p.next && null != p.next.next) {
            p = p.next.next;
            q = q.next;
            pos ++;
        }
        if (null == p.next || null == p.next.next) {
            pos = -1;
            return false;
        } else {
            return true;
        }
    }
}
