package 字节;

import 每日一题.TreeNode;

/**
 * Title: 二叉树的直径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-23
 */
public class 二叉树的直径 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum (TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftMaxSum = Math.max(maxSum(root.left), 0);
        int rightMaxSum = Math.max(maxSum(root.right), 0);

        int curMaxSum = leftMaxSum + rightMaxSum;

        max = Math.max(max, curMaxSum);

        return 1 + Math.max(leftMaxSum, rightMaxSum);
    }

}
