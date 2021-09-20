package codetop;

import 工具类.树;
import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 二叉树的最小深度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (null == tmp.left && null == tmp.right) {
                    return len;
                }
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        二叉树的最小深度 res = new 二叉树的最小深度();
        TreeNode tree = 树.buildTree("3_9_20_N_N_15_7");
        System.out.println(res.minDepth(tree));
    }
}
