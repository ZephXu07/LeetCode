package 剑指offer;

import java.util.*;

/**
 * Title: 从上到下打印二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode tmp;
        queue.offer(root);
        int layer = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                tmp = queue.remove();
                level.add(tmp.val);
                if (null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if (null != tmp.right) {
                    queue.offer(tmp.right);
                }
            }
            if (layer % 2 == 0) {
                Collections.reverse(level);
            }
            layer++;
            res.add(level);
        }
        return res;
    }




    public static void main(String[] args) {
        从上到下打印二叉树III res = new 从上到下打印二叉树III();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        for (List<Integer> l : res.levelOrder(root)) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
