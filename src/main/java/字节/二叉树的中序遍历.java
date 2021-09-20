package 字节;

import 每日一题.TreeNode;

import java.util.*;

/**
 * Title: 二叉树的中序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 二叉树的中序遍历 {
    private List<Integer> res;
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        res = new LinkedList<>();
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (null == root) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }


}
