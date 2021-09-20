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
public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode tmp;
        queue.offer(root);
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            res.add(tmp.val);
            if (null != tmp.left) {
                queue.offer(tmp.left);
            }
            if (null != tmp.right) {
                queue.offer(tmp.right);
            }
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for (int i : res) {
            ans[index++] = i;
        }
        return ans;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        从上到下打印二叉树 res = new 从上到下打印二叉树();
        System.out.println(Arrays.toString(res.levelOrder(root)));
    }
}
