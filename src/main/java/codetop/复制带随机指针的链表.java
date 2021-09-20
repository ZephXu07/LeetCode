package codetop;

/**
 * Title: 复制带随机指针的链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 复制带随机指针的链表 {
    public Node copyRandomList(Node head) {
        Node fake = new Node(-10001);
        fake.next = head;
        Node cur = head;
        while (null != cur) {
            Node tmp = new Node(cur.val);
            tmp.random = cur.random;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while (null != cur) {
            if (null != cur.next.random) {
                cur.next.random = cur.next.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node my = fake;
        while (null != cur) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            cur = cur.next;
            my.next = tmp;
            my = my.next;
        }
        return fake.next;
    }


    public static void main(String[] args) {
        复制带随机指针的链表 res = new 复制带随机指针的链表();
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        final Node node = res.copyRandomList(n1);
        System.out.println();
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
