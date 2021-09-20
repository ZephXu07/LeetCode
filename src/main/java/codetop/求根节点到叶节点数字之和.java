package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 求根节点到叶节点数字之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-21
 */
public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (null == tmp.left && null == tmp.right) {
                    sum += tmp.val;
                }
                if (null != tmp.left) {
                    tmp.left.val += tmp.val * 10;
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    tmp.right.val += tmp.val * 10;
                    queue.offer(tmp.right);
                }
            }
        }
        return sum;
    }
}
