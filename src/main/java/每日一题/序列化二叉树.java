package 每日一题;


import 工具类.树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 序列化二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-30
 */
public class 序列化二叉树 {
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        return levelTraverse(root);
    }

    private String levelTraverse (TreeNode root) {
        String NULL = "n";
        String DOT = "、";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.append(root.val).append(DOT);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                    res.append(node.left.val).append(DOT);
                } else {
                    res.append(NULL).append(DOT);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                    res.append(node.right.val).append(DOT);
                } else {
                    res.append(NULL).append(DOT);
                }
            }
        }
        return res.toString();
    }


    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        return levelBuild(data);
    }

    private TreeNode levelBuild (String tree) {
        String NULL = "n";
        String DOT = "、";
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = tree.split(DOT);
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right = new TreeNode(5);
        root.right.right.left = null;
        root.right.right.right = null;

        序列化二叉树 res = new 序列化二叉树();
        String tree = res.serialize(root);
        System.out.println(tree);
        final TreeNode deserialize = res.deserialize(tree);


    }
}
