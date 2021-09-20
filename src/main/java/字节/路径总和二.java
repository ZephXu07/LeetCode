package 字节;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 路径总和二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 路径总和二 {
    private List<List<Integer>> res;
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        List<Integer> track = new LinkedList<>();
        this.targetSum = targetSum;
        helper(0, track, root);
        return res;
    }

    public void helper(int sum, List<Integer> track, TreeNode root) {
        int tmp = root.val + sum;
        if (tmp == targetSum && null == root.left && null == root.right) {
            track.add(root.val);
            res.add(track);
            return;
        }
        track.add(root.val);
        if (root.left != null) {
            List<Integer> list = new LinkedList<>(track);
            helper(tmp, list, root.left);
        }
        if (root.right != null) {
            List<Integer> list = new LinkedList<>(track);
            helper(tmp, list, root.right);
        }
            track.remove(track.size() - 1);
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(5);
//        TreeNode root2 = new TreeNode(4);
//        TreeNode root3 = new TreeNode(8);
//        TreeNode root4 = new TreeNode(11);
//        TreeNode root5 = new TreeNode(13);
//        TreeNode root6 = new TreeNode(4);
//        TreeNode root7 = new TreeNode(7);
//        TreeNode root8 = new TreeNode(2);
//        TreeNode root9 = new TreeNode(5);
//        TreeNode root10 = new TreeNode(1);
//        root1.left = root2;
//        root1.right = root3;
//        root2.left = root4;
//        root3.left = root5;
//        root3.right = root6;
//        root4.left = root7;
//        root4.right = root8;
//        root6.left = root9;
//        root6.right = root10;
        TreeNode root1 = new TreeNode(-2);
        root1.right = new TreeNode(-3);

        路径总和二 res = new 路径总和二();
        List<List<Integer>> lists = res.pathSum(root1, -5);
        for (List<Integer> l : lists) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
