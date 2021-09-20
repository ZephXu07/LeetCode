package codetop;

import 每日一题.TreeNode;

/**
 * Title: 完全二叉树的节点个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        int left = 0;
        int right = 0;
        TreeNode l = root;
        TreeNode r = root;
        while (null != l) {
            l = l.left;
            left ++;
        }
        while (null != r) {
            r = r.right;
            right ++;
        }
        if (left == right) {
            /*
                以 root 为根节点的子树如果左右节点的层数完全一样，
                即此子树是完全二叉树，可以直接计算节点数
                2^len - 1

             */
            return (int) Math.pow(2, left) - 1;
        }
        /*
            如果不是完全二叉树，则计算左、右子树的节点数
            再加根节点 1
            而计算左、右子树的节点数又可以使用同样方法，直接递归
         */
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
