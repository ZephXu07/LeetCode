package codetop;

import 每日一题.TreeNode;

/**
 * Title: 路径总和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-07
 */
public class 路径总和 {
    private boolean flag;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        flag = false;
        dfs(root, 0, targetSum);
        return flag;

    }

    private void dfs (TreeNode root, int sum, int target) {
        if (flag) {
            return;
        }
        if (null == root) {
            return;
        }
        sum += root.val;
        if (sum == target && null == root.left && null == root.right) {
            flag = true;
            return;
        }
        dfs(root.left, sum, target);
        dfs(root.right, sum, target);
    }

}
