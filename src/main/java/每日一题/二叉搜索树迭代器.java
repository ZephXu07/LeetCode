package 每日一题;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉搜索树迭代器
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-28
 */
public class 二叉搜索树迭代器 {
}
//class BSTIterator {
//
//    List<Integer> tree;
//    private int inx;
//    public BSTIterator(TreeNode root) {
//        tree = new ArrayList<>();
//        inx = 0;
//        helper(root);
//    }
//
//    public int next() {
//        return tree.get(inx++);
//    }
//
//    public boolean hasNext() {
//        return inx < tree.size();
//    }
//
//    private void helper (TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        helper(root.left);
//        tree.add(root.val);
//        helper(root.right);
//    }
//
//}
class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (null != cur) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return null != cur || !stack.isEmpty();
    }
}
