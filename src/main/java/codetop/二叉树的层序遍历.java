package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: 二叉树的层序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-27
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            /*
                链表，头插
             */
            res.add(0, level);
        }
        return res;
    }
}
