package 每日一题;

/**
 * Title: 二叉搜索树节点最小距离
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-13
 */
public class 二叉搜索树节点最小距离 {
    private int pre;
    private int min;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        inOrder(root);
        return min;
    }

    private void inOrder (TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        inOrder(root.right);
    }
}
