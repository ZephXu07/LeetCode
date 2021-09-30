package codetop;

import 每日一题.TreeNode;

/**
 * Title: 最大二叉树654
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 最大二叉树654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs (int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int inx = start;
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                inx = i;
            }
        }

        TreeNode root = new TreeNode(nums[inx]);
        root.left = dfs(nums, start, inx - 1);
        root.right = dfs(nums, inx + 1, end);

        return root;

    }


}
