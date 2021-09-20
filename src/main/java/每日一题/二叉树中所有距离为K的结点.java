package 每日一题;

import 工具类.树;

import java.util.*;

/**
 * Title: 二叉树中所有距离为K的结点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-28
 */
public class 二叉树中所有距离为K的结点 {
    private Map<Integer, TreeNode> parents;
    private List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        res = new LinkedList<>();
        dfsParent(root);
        dfsCount(target, null, 0, k);
        return res;
    }

    private void dfsParent (TreeNode root) {
        if (null != root.left) {
            parents.put(root.left.val, root);
            dfsParent(root.left);
        }
        if (null != root.right) {
            parents.put(root.right.val, root);
            dfsParent(root.right);
        }
    }

    private void dfsCount (TreeNode node, TreeNode from, int depth, int k) {
        if (null == node) {
            return;
        }
        if (depth == k) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {
            dfsCount(node.left, node, depth + 1, k);
        }

        if (node.right != from) {
            dfsCount(node.right, node, depth + 1, k);
        }

        TreeNode tmp = parents.get(node.val);
        if (tmp != from) {
            dfsCount(tmp, node, depth + 1, k);
        }
    }


    public static void main(String[] args) {
        二叉树中所有距离为K的结点 res = new 二叉树中所有距离为K的结点();
        String data = "0_N_1_2_5_N_3_N_N_N_4";
        final TreeNode treeNode = 树.buildTree(data);
        TreeNode target = new TreeNode(2);
        int k = 2;
        final List<Integer> integers = res.distanceK(treeNode, target, k);
        for (int i : integers) {
            System.out.print(i + "\t");
        }
    }

}
