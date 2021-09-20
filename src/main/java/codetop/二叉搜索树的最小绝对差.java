package codetop;

import 每日一题.TreeNode;

/**
 * Title: 二叉搜索树的最小绝对差
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 二叉搜索树的最小绝对差 {
    private int pre;
    private int min;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        inOrder(root);
        return min;
    }

    private void inOrder (TreeNode root) {
        /*
            二叉搜索树中序遍历递增，绝对值最小相邻
         */
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
