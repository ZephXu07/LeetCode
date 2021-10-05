package 剑指offer专项突击版;

/**
 * Title: 二叉树剪枝047
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-05
 */
public class 二叉树剪枝047 {
    public TreeNode pruneTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        return haveOne(root) ? root : null;
    }

    private boolean haveOne (TreeNode root) {
        if (null == root) {
            return false;
        }
        boolean l = haveOne(root.left);
        boolean r = haveOne(root.right);

        if (!l) {
            root.left = null;
        }
        if (!r) {
            root.right = null;
        }

        return root.val == 1 || l || r;

    }
}
