package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 从上到下打印二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode tmp;
        queue.offer(root);
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
            res.add(level);
        }
        return res;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        从上到下打印二叉树II res = new 从上到下打印二叉树II();
        for (List<Integer> l : res.levelOrder(root)) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
