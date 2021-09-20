package codetop;

import 每日一题.TreeNode;

/**
 * Title: 相同的树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-14
 */
public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p) {
            return null == q;
        }
        if (null == q) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
