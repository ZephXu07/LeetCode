package codetop;

import 每日一题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 打家劫舍3
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-09
 */
public class 打家劫舍3 {
//    private Map<TreeNode, Integer> yes;
//    private Map<TreeNode, Integer> no;
//    public int rob(TreeNode root) {
//        yes = new HashMap<>();
//        no = new HashMap<>();
//        dfs(root);
//        return Math.max(yes.getOrDefault(root, 0),
//                no.getOrDefault(root, 0));
//    }
//
//    private void dfs (TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        dfs(root.left);
//        dfs(root.right);
//        yes.put(root, no.getOrDefault(root.left, 0)
//                + no.getOrDefault(root.right, 0) + root.val);
//
//        no.put(root, Math.max(yes.getOrDefault(root.left, 0),
//                        no.getOrDefault(root.left, 0)) +
//                Math.max(yes.getOrDefault(root.right, 0),
//                        no.getOrDefault(root.right, 0)));
//    }

    public int rob(TreeNode root) {
        /*
            以 root 为子树的根节点的抢与不抢
            res[0] 抢
            res[1] 不抢
         */
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs (TreeNode root) {
        if (null == root) {
            /*
                节点为空，以此节点为子树的根节点抢与不抢均为 0
             */
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        /*
            以左节点为子树的根节点的抢与不抢
         */
        int[] r = dfs(root.right);
        /*
            以右节点为子树的根节点的抢与不抢
         */
        int yes = root.val + l[1] + r[1];
        /*
            根节点选择抢，则左右子树根节点不能抢
         */
        int no = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        /*
            根节点选择不抢
            选择左子树中根节点的抢与不抢最大的
            右子树同理
         */
        return new int[] {yes, no};

    }

}
