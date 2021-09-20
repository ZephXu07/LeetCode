package 字节;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: 二叉树的右视图
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-20
 */
public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = queue.poll();
                if (i == size - 1) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return res;
    }
}
