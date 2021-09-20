package codetop;

import 每日一题.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Title: 二叉树中所有距离为K的结点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 二叉树中所有距离为K的结点 {
    private Map<Integer, TreeNode> parents;
    /*
        节点唯一，使用值代替
        节点与其父结点
     */
    private List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        res = new LinkedList<>();
        dfsParent(root);
        dfsCount(target, null, 0, k);
        return res;
    }

    private void dfsParent (TreeNode root) {
        /*
            建立 节点与父结点映射的哈希表
         */
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
        /*
            不仅左右子节点遍历，还有父结点也遍历
            同时注意此节点是不是由上述节点转移而来，
            是则跳过
         */
        TreeNode tmp = parents.get(node.val);
        if (tmp != from) {
            dfsCount(tmp, node, depth + 1, k);
        }
    }
}
