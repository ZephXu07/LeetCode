package codetop;

import 每日一题.TreeNode;

/**
 * Title: 另一棵树的子树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (null == root) {
            return false;
        }
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean dfs (TreeNode root, TreeNode subRoot) {
        if (null == subRoot && null == root) {
            return true;
        }
        if (null == root || null == subRoot) {
            return false;
        }
        if (root.val == subRoot.val) {
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
        return false;
    }
}
