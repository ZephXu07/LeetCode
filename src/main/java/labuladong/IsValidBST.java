package labuladong;

/**
 * Title: labuladong.IsValidBST
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (null != min && root.val <= min.val) {
            return false;
        }
        if (null != max && root.val >= max.val) {
            return false;
        }
        return helper(root.left, min, root) && helper(root.right, root, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        IsValidBST res = new IsValidBST();
        boolean validBST = res.isValidBST(root);
        System.out.println(validBST);
    }
}
