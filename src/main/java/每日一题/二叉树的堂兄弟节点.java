package 每日一题;

import labuladong.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 二叉树的堂兄弟节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-17
 */
public class 二叉树的堂兄弟节点 {
//    private Map<Integer, Node> memo;
//    public boolean isCousins(TreeNode root, int x, int y) {
//        memo = new HashMap<>();
//        dfs(root, null, 0);
//        Node xNode = memo.get(x);
//        Node yNode = memo.get(y);
//        if (null == xNode || null == yNode) {
//            return false;
//        }
//        return xNode.level == yNode.level
//                && xNode.parLevel == yNode.parLevel
//                && xNode.parent != yNode.parent;
//    }
//
//    private void dfs (TreeNode root, TreeNode parent, int level) {
//        if (null == root) {
//            return;
//        }
//        if (level == 0) {
//            Node node = new Node(0, null, -1);
//            memo.put(root.val, null);
//        } else {
//            Node node = new Node(level, parent, level - 1);
//            memo.put(root.val, node);
//        }
//        dfs(root.left, root,level + 1);
//        dfs(root.right, root,level + 1);
//    }
//
//    class Node {
//        int level;
//        TreeNode parent;
//        int parLevel;
//
//        public Node(int level, TreeNode parent, int parLevel) {
//            this.level = level;
//            this.parent = parent;
//            this.parLevel = parLevel;
//        }
//    }


    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        // 如果两个节点都找到了，就可以提前退出遍历
        // 即使不提前退出，对最坏情况下的时间复杂度也不会有影响
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {
            return;
        }

        dfs(node.right, depth + 1, node);
    }

}
