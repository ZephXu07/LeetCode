package 每日一题;

/**
 * Title: 二叉树中第二小的节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-27
 */
public class 二叉树中第二小的节点 {
    private int min;
    private int res;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        res = -1;
        dfs(root);
        return res;
    }

    private void dfs (TreeNode root) {
        if (null == root) {
            return;
        }

        if (res != -1 && root.val >= res) {
            return;
        }

        if (root.val > min) {
            /*
                已经是小于 res 的原先值
                再大于 min 就是目前已遍历的第二小的
             */
            res = root.val;
        }
        dfs(root.left);
        dfs(root.right);


    }

    public static void main(String[] args) {
        二叉树中第二小的节点 res = new 二叉树中第二小的节点();

    }
}
