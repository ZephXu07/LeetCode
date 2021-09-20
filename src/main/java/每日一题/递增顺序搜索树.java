package 每日一题;

import labuladong.Solution;
import 工具类.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 递增顺序搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-25
 */
public class 递增顺序搜索树 {

//    public TreeNode increasingBST(TreeNode root) {
//        List<Integer> res = new LinkedList<>();
//        helper(root, res);
//
//        TreeNode head = new TreeNode(-1);
//        TreeNode cur = head;
//        for (int value : res) {
//            cur.right = new TreeNode(value);
//            cur = cur.right;
//        }
//        return head.right;
//    }
//
//    public void helper(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        helper(root.left, res);
//        res.add(root.val);
//        helper(root.right, res);
//    }

    private TreeNode res;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        res = head;
        inorder(root);
        return head.right;
    }

    public void inorder(TreeNode root) {
        /* 遍历到一个节点时，把它的左孩子设为空，
        并将其本身作为上一个遍历到的节点的右孩子
         */
        if (root == null) {
            return;
        }
        inorder(root.left);

        // 在中序遍历的过程中修改节点指向
        res.right = root;
        root.left = null;
        //在最深一层递归结束时左子节点是空，
        // 但中间其他层可能左节点存在，需要断开
        res = root;

        inorder(root.right);
    }





    public static void main(String[] args) {
        递增顺序搜索树 res = new 递增顺序搜索树();
        String data = "5_3_6_2_4_N_8_1_N_N_N_7_9";
        TreeNode tree = 树.buildTree(data);
        System.out.println(树.levelTraverse(res.increasingBST(tree)));
    }
}
