package labuladong;

/**
 * Title: labuladong.Connect
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-22
 */
public class Connect {
    public Node connect(Node root) {
        if (null == root) {
            return root;
        }
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node l, Node r) {
        if (null == l || r == null) {
            return;
        }
        l.next = r;
        helper(l.left, l.right);
        helper(r.left, r.right);
        helper(l.right, r.left);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
};
