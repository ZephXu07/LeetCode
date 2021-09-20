package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 找树左下角的值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp = root;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                tmp = queue.poll();



                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }

                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
            }
        }

        return tmp.val;
    }
}
