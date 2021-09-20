package 字节;

import 每日一题.TreeNode;

/**
 * Title: 平衡二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-09
 */
public class 平衡二叉树 {
//    public boolean isBalanced(TreeNode root) {
//        if (null == root) {
//            return true;
//        }
//        boolean left = isBalanced(root.left);
//        boolean right = isBalanced(root.right);
//        boolean cur = Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
//        return left && right && cur;
//    }
//
//    private int getHeight (TreeNode root) {
//        if (null == root) {
//            return 0;
//        }
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//        return Math.max(left, right) + 1;
//    }
    //自顶向下，不合格

    public boolean isBalanced (TreeNode root) {
        return balanced(root) >= 0;
    }

    private int balanced (TreeNode root) {
        if (null == root) {
            return 0;
        }
        int l;
        int r;
        if ((l = balanced(root.left)) == -1
            || (r = balanced(root.right)) == -1
            || Math.abs(l - r) > 1){
            //短路或 || ,当左子树不满足时返回，剪枝，右子树同理
            return -1;
        }

        return Math.max(l, r) + 1;
    }
}
