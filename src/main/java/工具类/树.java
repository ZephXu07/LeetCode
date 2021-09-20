package 工具类;

import 剑指offer.ListNode;
import 每日一题.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-25
 */
public class 树 {
    private final static String NULL = "N";
    private final static String SEPARATOR = "_";
    public static TreeNode buildTree(String data) {
        if (null == data) {
            return null;
        }
        String[] nodes = data.split(SEPARATOR);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        TreeNode parent;
        for (int i = 1; i < nodes.length;) {
            parent = queue.poll();
            String left = nodes[i++];
            if (!NULL.equals(left)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }
            String right = nodes[i++];
            if (!NULL.equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }

    public static String levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        queue.offer(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (null == tmp) {
                builder.append(NULL).append(SEPARATOR);
                continue;
            }
            builder.append(tmp.val).append(SEPARATOR);
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
        return builder.toString();
    }

}
