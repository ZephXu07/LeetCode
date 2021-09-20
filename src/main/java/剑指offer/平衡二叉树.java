package 剑指offer;

/**
 * Title: 平衡二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-07
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = helper(root.left);
        if (-1 == left) {
            return -1;
        }
        int right = helper(root.right);
        if (-1 == right) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
