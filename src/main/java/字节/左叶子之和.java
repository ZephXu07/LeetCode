package 字节;

import 每日一题.TreeNode;

/**
 * Title: 左叶子之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-04
 */
public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int res = 0;
        if (null != root.left) {
            if (null == root.left.left && null == root.left.right) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        if (null != root.right) {
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }
}
