package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Title: 序列化二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 序列化二叉树 {
    private final String NULL = "N";
    private final String SEPARATOR = "_";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);
        return builder.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append(NULL).append(SEPARATOR);
            return;
        }
        builder.append(root.val).append(SEPARATOR);
        serializeHelper(root.left, builder);
        serializeHelper(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(SEPARATOR);
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(strings));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(LinkedList<String> nodes) {
        if (null == nodes || nodes.isEmpty()) {
            return null;
        }
        String val = nodes.removeFirst();
        if (NULL.equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
        序列化二叉树 res = new 序列化二叉树();
        String s = res.serialize(root);
        System.out.println(s);
        TreeNode treeNode = res.deserialize(s);
        System.out.println(treeNode);
    }
}
