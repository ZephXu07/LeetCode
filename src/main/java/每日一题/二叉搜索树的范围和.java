package 每日一题;

import 工具类.树;

/**
 * Title: 二叉搜索树的范围和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-27
 */
public class 二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null == root) {
            return 0;
        }
        int left = root.val < low ? 0 : rangeSumBST(root.left, low, high);
        int right = root.val > high ? 0 : rangeSumBST(root.right, low, high);
        int val = root.val >= low && root.val <= high ? root.val : 0;
        return left + right + val;
    }


    public static void main(String[] args) {
//        String data = "10_5_15_3_7_13_18_1_N_6_N_";
//        int low = 6;
//        int high = 10;
        String data = "10_5_15_3_7_N_18_";
        int low = 7;
        int high = 15;
        TreeNode treeNode = 树.buildTree(data);
        二叉搜索树的范围和 range = new 二叉搜索树的范围和();

        System.out.println(range.rangeSumBST(treeNode, low, high));
    }
}
