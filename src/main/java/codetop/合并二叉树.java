package codetop;

import 每日一题.TreeNode;

/**
 * Title: 合并二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge (TreeNode old1, TreeNode old2) {
        if (null == old1 && null == old2) {
            return null;
        }
        int val1 = old1 == null ? 0 : old1.val;
        int val2 = old2 == null ? 0 : old2.val;
        TreeNode root = new TreeNode(val1 + val2);
        root.left = merge(old1 == null ? null : old1.left, old2 == null ? null : old2.left);
        root.right = merge(old1 == null ? null : old1.right , old2 == null ? null : old2.right);
        return root;
    }
}
