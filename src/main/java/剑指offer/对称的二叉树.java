package 剑指offer;

/**
 * Title: 对称的二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val
                && isSym(left.left, right.right)
                && isSym(left.right, right.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        对称的二叉树 tree = new 对称的二叉树();
        System.out.println(tree.isSymmetric(root));
    }

}
