package 剑指offer;

/**
 * Title: 二叉树的最近公共祖先
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-08
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) {
            return root;
        }
        if (null == left && null == right) {
            return null;
        }
        return left == null ? right : left;
    }
}
