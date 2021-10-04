package 剑指offer专项突击版;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: 二叉树每层的最大值044
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 二叉树每层的最大值044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                max = Math.max(max, tmp.val);
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }

                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
            }
            res.add(max);
        }
        return res;


    }
}
