package codetop;

/**
 * Title: 填充每个节点的下一个右侧节点指针II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-28
 */
public class 填充每个节点的下一个右侧节点指针II {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node cur = root;
        Node head = new Node(-101);
        Node fol;
        while (null != cur) {
            head.next = null;
            /*
                为了使空间复杂度降为 O(1)
             */
            /*
                虚拟头节点
             */
            fol = head;
            while (null != cur) {
                /*
                    遍历当前一层节点
                 */
                if (null != cur.left) {
                    fol.next = cur.left;
                    fol = fol.next;
                }
                if (null != cur.right) {
                    fol.next = cur.right;
                    fol = fol.next;
                }
                cur = cur.next;
                /*
                    直到当前层节点遍历完
                 */
            }
            cur = head.next;
            /*
                重点，while 循环是 cur 多层
                一开始是赋值 root 根节点
                后面是赋值每一层的真实头节点
                于是自然而然就进入了新的一层，再遍历其子节点
             */
        }
        return root;
    }



}
