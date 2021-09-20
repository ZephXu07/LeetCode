package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 翻转等价二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 翻转等价二叉树 {
//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        if (root1 == root2) {
//            return true;
//        }
//
//        if (null == root1 || null == root2 || root1.val != root2.val) {
//            return false;
//        }
//
//        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
//                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
//
//    }


    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);

    }

    public void dfs (TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        int l = root.left == null ? -1 : root.left.val;
        int r = root.right == null ? -1 : root.right.val;

        list.add(root.val);

        if (l < r) {
            dfs(root.left, list);
            dfs(root.right, list);
        } else {
            dfs(root.right, list);
            dfs(root.left, list);
        }
        list.add(null);
        /*
            保证树深度一样
         */
    }

    public static void main(String[] args) {
        翻转等价二叉树 res = new 翻转等价二叉树();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = null;

        System.out.println(res.flipEquiv(r1, r2));
    }
}
