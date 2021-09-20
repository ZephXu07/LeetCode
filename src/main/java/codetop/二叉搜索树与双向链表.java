package codetop;

/**
 * Title: 二叉搜索树与双向链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 二叉搜索树与双向链表 {
    class Node {
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


    private Node head;
    private Node pre;
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        pre = null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs (Node node) {
        if (null == node) {
            return;
        }
        dfs(node.left);
        if (null == pre) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }

}
