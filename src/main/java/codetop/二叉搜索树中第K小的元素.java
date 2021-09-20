package codetop;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 二叉搜索树中第K小的元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-03
 */
public class 二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || null != root) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
