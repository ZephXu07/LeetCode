package 剑指offer专项突击版;

/**
 * Title: 排序的循环链表029
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 排序的循环链表029 {
    public Node insert(Node head, int insertVal) {
        if (null == head) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node cur = head;
        /*
            三种情况
            1.在升序时候，cur <= cur.next
                    此时 cur <= insertVal <= cur.next
                    新建节点在 cur 与 cur.next 中间
                    因为  cur >= insertVal <= cur.next
            2.在降序的时候，即 cur Max，cur.next Min
                    1.如果 cur.next >= insertVal
                        insertVal 是最小的节点
                        新建节点在 cur 与 cur.next 中间
                        因为  cur >= insertVal <= cur.next
                   2.如果 insertVal >= cur
                        insertVal 是最大的节点
                        新建节点在 cur 与 cur.next 中间形成升序
                        因为  cur <= insertVal >= cur.next

         */
        while (cur.next != head) {
            if (cur.val > cur.next.val) {
                if (cur.next.val >= insertVal) {
                    break;
                }
                if (cur.val <= insertVal) {
                    break;
                }
            }
            if (cur.val <= insertVal && insertVal <= cur.next.val) {
                break;
            }
            cur = cur.next;
        }
        Node tmp = new Node(insertVal);
        tmp.next = cur.next;
        cur.next = tmp;
        return head;
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
