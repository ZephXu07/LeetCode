package 字节;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉树的前序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-09
 */
public class 二叉树的前序遍历 {
//    private List<Integer> res;
//    public List<Integer> preorderTraversal(TreeNode root) {
//        res = new LinkedList<>();
//        helper(root);
//        return res;
//    }
//
//    private void helper (TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        res.add(root.val);
//        helper(root.left);
//        helper(root.right);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (null != tmp) {
                res.add(tmp.val);
                stack.push(tmp.right);
                stack.push(tmp.left);
            }

        }
        return res;
    }
}
