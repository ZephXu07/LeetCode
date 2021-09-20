package 剑指offer;

/**
 * Title: 二叉树的深度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-04
 */
public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1: right + 1;
    }


}
