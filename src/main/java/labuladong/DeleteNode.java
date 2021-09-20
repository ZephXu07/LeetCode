package labuladong;

/**
 * Title: labuladong.DeleteNode
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (key == root.val) {
            if (null == root.left) {
                return root.right;
            }
            if (null == root.right) {
                return root.left;
            }
            TreeNode tmp = root;
            root = getMin(root.right);
            root.right = deleteMin(tmp.right);
            root.left = tmp.left;

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    private TreeNode getMin(TreeNode node) {
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        DeleteNode deleteNode = new DeleteNode();
        root = deleteNode.deleteNode(root, 3);
        System.out.println(root);
    }
}
