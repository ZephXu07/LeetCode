package codetop;

import 每日一题.TreeNode;

/**
 * Title: 二叉搜索树中的插入操作
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (val > cur.val) {
                if (null != cur.right) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (null != cur.left) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
