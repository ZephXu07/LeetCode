package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 层数最深叶子节点的和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (null != cur.left) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }
            }
        }
        return sum;
    }


}
