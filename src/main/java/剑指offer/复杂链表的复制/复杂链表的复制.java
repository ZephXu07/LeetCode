package 剑指offer.复杂链表的复制;

/**
 * Title: 复杂链表的复制
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 复杂链表的复制 {
//    public Node copyRandomList(Node head) {
//        Map<Node, Node> memo = new HashMap<>();
//        Node cur = head;
//        while (null != cur) {
//            memo.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        while (null != cur) {
//            memo.get(cur).next = memo.get(cur.next);
//            memo.get(cur).random = memo.get(cur.random);
//            cur = cur.next;
//        }
//        return memo.get(head);
//    }


    public Node copyRandomList(Node head){
        if (null == head) {
            return null;
        }
        Node old = head;
        Node copyed;
        while (null != old) {
            copyed = new Node(old.val);
            copyed.next = old.next;
            old.next = copyed;
            old = copyed.next;
        }
        old = head;
        while (null != old) {
            if (null != old.random) {
                old.next.random = old.random.next;
            }
            old = old.next.next;
        }
        old = head;
        Node nodeList = old.next;
        copyed = nodeList;
        while (null != old) {
            old.next = old.next.next;
            if (null != copyed.next) {
                copyed.next = copyed.next.next;
            }
            old = old.next;
            copyed = copyed.next;
        }
        return nodeList;
    }
}
