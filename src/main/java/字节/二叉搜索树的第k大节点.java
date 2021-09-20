package 字节;

import 每日一题.TreeNode;

/**
 * Title: 二叉搜索树的第k大节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class 二叉搜索树的第k大节点 {
    private int res;
    private int count;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (null == root) {
            return;
        }
        helper(root.right);
        if (count == 0) {
            return;
        }
        count --;
        if (count == 0) {
            res = root.val;
        }
        helper(root.left);
    }
}
