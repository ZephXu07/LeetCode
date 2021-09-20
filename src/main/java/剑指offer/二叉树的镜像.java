package 剑指offer;

/**
 * Title: 二叉树的镜像
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        change(root);
        return root;
    }
    private void change(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        change(root.left);
        change(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        二叉树的镜像 res = new 二叉树的镜像();
        TreeNode mirrorTree = res.mirrorTree(root);
        System.out.println(mirrorTree);
    }
}
