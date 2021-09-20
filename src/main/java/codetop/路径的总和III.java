package codetop;


import 每日一题.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 路径的总和III
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 路径的总和III {
//    public int pathSum(TreeNode root, int targetSum) {
//        if (null == root) {
//            return 0;
//        }
//        int res = 0;
//        res += dfs(root, 0, targetSum);
//        res += pathSum(root.left, targetSum);
//        res += pathSum(root.right, targetSum);
//        return res;
//    }
//
//    private int dfs (TreeNode root, int sum, int targetSum) {
//        if (null == root) {
//            return 0;
//        }
//        sum += root.val;
//
//        int res = 0;
//        if (sum == targetSum) {
//            res++;
//        }
//
//        res += dfs(root.left, sum, targetSum);
//        res +=dfs(root.right, sum, targetSum);
//        return res;
//    }

    private Map<Integer, Integer> map;
    private int tar;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0, 1);
        /*
            前缀和
            存放 (0,1) 方便计算从根节点出发和为 tar 的路径
         */
        tar = targetSum;
        return dfs(root, 0);
    }

    private int dfs (TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }

        int res = 0;

        sum += root.val;
        /*
            路径和
         */

        res += map.getOrDefault(sum - tar, 0);
        /*
            sum 是从根到当前节点的总路径和
            tar 是部分节点的和
            sum - tar 如果存在的话即存在
            从根到当前节点，或者某个节点到当前节点路径和 target
            次数表示了有多少如此的路径
            前缀和的思想 pre[j] - pre[i] .....
         */

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        /*
            更新
         */

        res += dfs(root.left, sum);
        res += dfs(root.right, sum);
        /*
            左右子树
         */

        map.put(sum, map.getOrDefault(sum, 0) - 1);
        /*
            此处是回溯，因为只能向下
         */

        return res;
    }



}
