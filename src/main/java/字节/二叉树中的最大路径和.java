package 字节;

import 每日一题.TreeNode;

/**
 * Title: 二叉树中的最大路径和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 二叉树中的最大路径和 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum (TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftMaxSum = Math.max(maxSum(root.left), 0);
        int rightMaxSum = Math.max(maxSum(root.right), 0);

        int curMaxSum = leftMaxSum + rightMaxSum + root.val;

        max = Math.max(max, curMaxSum);

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }


}
