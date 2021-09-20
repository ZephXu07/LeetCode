package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 二叉树的最大宽度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 二叉树的最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(new Tree(root, 1));
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Tree first = queue.peek();
            Tree last = null;
            for (int i = 0; i < size; i++) {
                Tree tree = queue.poll();
                if (i == size - 1) {
                    last = tree;
                }
                if (null != tree.node.left) {
                    queue.add(new Tree(tree.node.left, tree.pos * 2));
                }
                if (null != tree.node.right) {
                    queue.add(new Tree(tree.node.right, tree.pos * 2 + 1));
                }
            }
            max = Math.max(max, last.pos - first.pos + 1);
        }
        return max;
    }
}
class Tree {
    TreeNode node;
    int pos;

    public Tree(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
