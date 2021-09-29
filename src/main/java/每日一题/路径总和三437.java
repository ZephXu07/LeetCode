package 每日一题;

import 工具类.树;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 路径总和三437
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-28
 */
public class 路径总和三437 {
//    private int res;
//    public int pathSum(TreeNode root, int targetSum) {
//        if (null == root) {
//            return 0;
//        }
//        res = 0;
//        helper(root, targetSum);
//        return res;
//
//    }
//
//    private void helper (TreeNode root, int targetSum) {
//        if (null == root) {
//            return;
//        }
//        dfs(root, 0, targetSum);
//        helper(root.left, targetSum);
//        helper(root.right, targetSum);
//    }
//
//    private void dfs (TreeNode root, int cur, int targetSum) {
//        if (null == root) {
//            return;
//        }
//
//        cur += root.val;
//        if (cur == targetSum) {
//            res++;
//        }
//        dfs(root.left, cur, targetSum);
//        dfs(root.right, cur, targetSum);
//    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, targetSum, map);
    }

    private int dfs (TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (null == root) {
            return 0;
        }
        int res = 0;
        sum += root.val;
        res += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        res += dfs(root.left, sum, target, map);
        res += dfs(root.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);

        return res;
    }



    public static void main(String[] args) {
        String s = "10_5_-3_3_2_N_11_3_-2_N_1";
        final TreeNode treeNode = 树.buildTree(s);
        路径总和三437 res = new 路径总和三437();
        System.out.println(res.pathSum(treeNode, 8));
    }
}
