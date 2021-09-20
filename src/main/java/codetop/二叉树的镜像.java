package codetop;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 二叉树的镜像
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        change(root);
        return root;
    }
    private void change(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        change(root.left);
        change(root.right);
    }
}
