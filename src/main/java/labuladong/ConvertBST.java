package labuladong;

/**
 * Title: labuladong.ConvertBST
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return null;
        }
        traverse(root);
        return root;
    }



    private void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
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
        ConvertBST convertBST = new ConvertBST();
        convertBST.convertBST(root);
        System.out.println(root.val);
    }
}
