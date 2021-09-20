package labuladong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: labuladong.Codec
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-24
 */
public class Codec {
    private final String NULL = "N";
    private final String SEPARATOR = "_";

    // Encodes a tree to a single string.
    public String serializePreorder(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializePreorder(root, builder);
        return builder.toString();
    }

    private void serializePreorder(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append(NULL).append(SEPARATOR);
            return ;
        }
        builder.append(root.val).append(SEPARATOR);
        serializePreorder(root.left, builder);
        serializePreorder(root.right, builder);
    }

    public String serializePostorder(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializePostorder(root, builder);
        return builder.toString();
    }

    private void serializePostorder(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append(NULL).append(SEPARATOR);
            return ;
        }
        serializePostorder(root.left, builder);
        serializePostorder(root.right, builder);
        builder.append(root.val).append(SEPARATOR);
    }

    public String serializeHierarchy(TreeNode root) {
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



//     Decodes your encoded data to tree.
    public TreeNode deserialize(String data, int way) {
        String[] strings = data.split("_");
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(strings));
        switch (way) {
            case 0:
                return deserializePreorder(nodes);
            case 1:
                return deserializePostorder(nodes);
            default:
                return deserializeHierarchy(data);
        }
    }



    private TreeNode deserializePreorder(LinkedList<String> nodes) {
        if (null == nodes || nodes.isEmpty()) {
            return null;
        }
        String value = nodes.removeFirst();
        if (NULL.equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializePreorder(nodes);
        root.right = deserializePreorder(nodes);
        return root;
    }
    private TreeNode deserializePostorder(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String value = nodes.removeLast();
        if (NULL.equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.right = deserializePostorder(nodes);
        root.left = deserializePostorder(nodes);
        return root;
    }
    private TreeNode deserializeHierarchy(String data) {
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


    public static void main(String[] args) {
        Codec codec = new Codec();
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
        String preorder = codec.serializePreorder(root);
        System.out.println(preorder);
        String postorder = codec.serializePostorder(root);
        System.out.println(postorder);
        String hierarchy = codec.serializeHierarchy(root);
        System.out.println(hierarchy);
        TreeNode preorderTree = codec.deserialize(preorder, 0);
        System.out.println(preorderTree.val);
        TreeNode postorderTree = codec.deserialize(postorder, 1);
        System.out.println(postorderTree);
        TreeNode hierarchyTree = codec.deserialize(hierarchy, 2);
        System.out.println(hierarchyTree);
    }
}
