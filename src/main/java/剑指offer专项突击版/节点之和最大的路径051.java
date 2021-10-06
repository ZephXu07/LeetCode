package 剑指offer专项突击版;

/**
 * Title: 节点之和最大的路径051
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 节点之和最大的路径051 {
    private int max;
    public int maxPathSum(TreeNode root) {
        max =  Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    /*
            返回 root 根节点和左子树、或右子树、或都不选择的最大值
            两选一，或者都不选
    */
    private int maxPath (TreeNode root) {
        if (null == root) {
            return 0;
        }


        int l = Math.max(maxPath(root.left), 0);
        int r = Math.max(maxPath(root.right), 0);
        /*
            题目要求选择最大的，0相当于不选
            因为有负数
            此时就得到了左右子树的最大贡献
            因为题目说的随意哪个节点的，所以每个节点及其左右子树都要比较
         */
        max = Math.max(max, root.val + l + r);

        return root.val + Math.max(l, r);
        /*
            返回当前的子树，此时 root 是某个子树的左子树或者右子树
         */
    }
}
