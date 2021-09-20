package 字节;

import java.util.*;
import 每日一题.*;
/**
 * Title: 字节.二叉树的锯齿形层序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-04
 */
public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean lToR = true;

        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();

            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = queue.poll();
                if (lToR) {
                    levelList.offerLast(tmp.val);
                } else {
                    levelList.offerFirst(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            lToR = !lToR;
        }
        return res;
    }

    public static void main(String[] args) {
//        字节.二叉树的锯齿形层序遍历 res = new 字节.二叉树的锯齿形层序遍历();
//        List<List<Integer>> lists = res.zigzagLevelOrder(root);
//        for (List<Integer> l : lists) {
//            System.out.println(Arrays.toString(l.toArray()));
//        }
    }
}
