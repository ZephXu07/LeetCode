package 字节;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 二叉树的完全性检验
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-23
 */
public class 二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean appearNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (appearNull && null != cur) {
                return false;
            }
            if (null == cur) {
                appearNull = true;
                continue;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }

    public static void main(String[] args) {
        二叉树的完全性检验 res = new 二叉树的完全性检验();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root2.left = root5;
        System.out.println(res.isCompleteTree(root1));
    }
}
