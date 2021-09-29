package 每日一题;

/**
 * Title: 扁平化多级双向链表430
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-28
 */
public class 扁平化多级双向链表430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

//    public Node flatten(Node head) {
//        if (null == head) {
//            return head;
//        }
//
//        Node dummy = new Node();
//        dummy.next = head;
//        Node cur = dummy.next;
//        while (null != cur) {
//            if (null != cur.child) {
//                Node tmp = flatten(cur.child);
//                /*
//                    处理好子节点及其后续节点和子子节点
//
//                 */
//                Node tail = tmp;
//                /*
//                    找到这一段的尾节点
//                 */
//                while (null != tail.next) {
//                    tail = tail.next;
//                }
//                Node next = cur.next;
//                cur.next = tmp;
//                tmp.prev = cur;
//                tail.next = next;
//                if (null != next) {
//                    next.prev = tail;
//                }
//                cur.child = null;
//                cur = tail;
//                /*
//                    节点指针的重新指向，
//                    注意当前的父结点可能后续没有节点了，需要判空
//                    再父结点跳到这一段的最后节点
//                 */
//            } else {
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//    }


//    public Node flatten(Node head) {
//        dfs(head);
//        return head;
//    }
//
//    private Node dfs(Node head) {
//        if (null == head) {
//            return head;
//        }
//        Node last = head;
//        Node cur = head;
//        while (null != cur) {
//            if (null != cur.child) {
//                Node tail = dfs(cur.child);
//                /*
//                    处理好子节点及其后续节点和子子节点
//                    及找到尾节点
//                 */
//                Node next = cur.next;
//                cur.next = cur.child;
//                cur.child.prev = cur;
//                if (null != tail) {
//                    tail.next = next;
//                }
//                if (null != next) {
//                    next.prev = tail;
//                }
//                cur.child = null;
//                last = cur;
//                cur = tail;
//                /*
//                    节点指针的重新指向，
//                    注意当前的父结点可能后续没有节点了，需要判空
//                    再父结点跳到这一段的最后节点
//                 */
//            } else {
//                last = cur;
//                cur = cur.next;
//            }
//        }
//        return last;
//    }

    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;

        while (null != head) {
            if (null != head.child) {
                Node next = head.next;
                Node child = head.child;

                head.next = child;
                child.prev = head;
                head.child = null;
                Node tail = child;
                while (null != tail.next) {
                    tail = tail.next;
                }

                tail.next = next;
                if (null != next) {
                    next.prev = tail;
                }
            }
            /*
                只是将子节点的末尾和当前节点的下一个节点连接起来而已
                子节点的子节点及等等要等 head 指针再去遍历
             */
            head = head.next;
        }
        return dummy.next;
    }



}
