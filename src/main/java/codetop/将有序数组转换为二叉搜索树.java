package codetop;

import 每日一题.TreeNode;

/**
 * Title: 将有序数组转换为二叉搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-22
 */
public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
            取中间左边作为根节点，根节点的左边是左子树，根节点的左边是右子树
         */
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs (int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

}

