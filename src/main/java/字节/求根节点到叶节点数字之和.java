package 字节;

import 每日一题.TreeNode;

import java.util.LinkedList;

/**
 * Title: 求根节点到叶节点数字之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs (TreeNode root, int pre) {
        if (null == root) {
            return 0;
        }
        int sum = pre * 10 + root.val;
        if (null == root.left && null == root.right) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }


    public static void main(String[] args) {
        求根节点到叶节点数字之和 res = new 求根节点到叶节点数字之和();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        System.out.println(res.sumNumbers(tree));
    }
}
