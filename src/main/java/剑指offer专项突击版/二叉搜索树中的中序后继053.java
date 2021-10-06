package 剑指offer专项突击版;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 二叉搜索树中的中序后继053
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 二叉搜索树中的中序后继053 {
//    private TreeNode res;
//    private boolean find;
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        res = null;
//        find = false;
//        dfs(root, p);
//        return res;
//    }
//
//    public void dfs (TreeNode root, TreeNode p) {
//        if (null == root || null != res) {
//            return;
//        }
//        dfs(root.left, p);
//
//        if (find && null == res) {
//            res = root;
//            return;
//        }
//        if (root == p) {
//            find = true;
//        }
//
//        dfs(root.right, p);
//    }

//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        boolean find = false;
//
//        while (null != root || !stack.isEmpty()) {
//            while (null != root) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (find) {
//                return root;
//            }
//            if (root == p) {
//                find = true;
//            }
//            root = root.right;
//        }
//
//        return null;
//    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (null != root) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > p.val) {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
