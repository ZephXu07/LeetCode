package codetop;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 验证二叉搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-21
 */
public class 验证二叉搜索树 {
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean helper(TreeNode root, long min, long max) {
//        if (null == root) {
//            return true;
//        }
//        if (root.val <= min || root.val >= max) {
//            return false;
//        }
//        return helper(root.left, min, (long) root.val) && helper(root.right, (long) root.val, max);
//    }

//    private long pre = Long.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        return inorder(root);
//    }
//
//    private boolean inorder (TreeNode root) {
//        if (null == root) {
//            return true;
//        }
//        if (!inorder(root.left)) {
//            return false;
//        }
//        if (root.val <= pre) {
//            return false;
//        }
//        pre = root.val;
//        return inorder(root.right);
//    }

    public boolean isValidBST(TreeNode root) {
         Deque<TreeNode> stack = new LinkedList<TreeNode>();
         double inorder = -Double.MAX_VALUE;
         while (!stack.isEmpty() || root != null) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
               // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
             if (root.val <= inorder) {
                 return false;
             }
             inorder = root.val;
             root = root.right;
         }
         return true;
    }
}
