package codetop;


import 工具类.树;
import 每日一题.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉树展开为链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-05
 */
public class 二叉树展开为链表 {
//    public void flatten(TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        List<TreeNode> res = new ArrayList<>();
//        preorder(root, res);
//        for (int i = 1; i < res.size(); i++) {
//            TreeNode pre = res.get(i - 1);
//            TreeNode cur = res.get(i);
//            pre.left = null;
//            pre.right = cur;
//        }
//    }
//
//    private void preorder (TreeNode root, List<TreeNode> res) {
//        if (null == root) {
//            return;
//        }
//        res.add(root);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }


//    public void flatten(TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        TreeNode pre= null;
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            if (null != pre) {
//                pre.left = null;
//                pre.right = cur;
//            }
//
//            if (null != cur.right) {
//                stack.push(cur.right);
//            }
//            if (null != cur.left) {
//                stack.push(cur.left);
//            }
//            pre = cur;
//        }
//    }

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode cur = root;
        while (null != cur) {
            TreeNode next = cur.left;
            if (null != next) {
                TreeNode pre = next;
                while (null != pre.right) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }

            cur = cur.right;
        }
    }


    public static void main(String[] args) {
        String s = "1_2_5_3_4_N_6";
        final TreeNode treeNode = 树.buildTree(s);
        二叉树展开为链表 res = new 二叉树展开为链表();
        res.flatten(treeNode);
        System.out.println();
    }
}
