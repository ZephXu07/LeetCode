package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 翻转二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-07
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
