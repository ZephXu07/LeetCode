package codetop;

/**
 * Title: 将二叉搜索树转化为排序的双向链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-23
 */
public class 将二叉搜索树转化为排序的双向链表 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        inOrder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private Node head;
    private Node tail;

    private void inOrder (Node cur) {
        if (null == cur) {
            return;
        }

        inOrder(cur.left);

        if (null == head) {
            head = cur;
        } else {
            tail.right = cur;
            cur.left = tail;
        }

        tail = cur;
        inOrder(cur.right);
    }

    public static void main(String[] args) {
        将二叉搜索树转化为排序的双向链表 res = new 将二叉搜索树转化为排序的双向链表();
        Node node0 = new Node(2);
//        node0.left = new Node(1);
//        node0.right = new Node(3);
        final Node node = res.treeToDoublyList(node0);
        System.out.println(node.val);
    }

}
