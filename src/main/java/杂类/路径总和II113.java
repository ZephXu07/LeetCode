package 杂类;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 路径总和II113
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-31
 */
public class 路径总和II113 {



    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, sum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, Deque<Integer> path) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, sum, res, path);
        dfs(root.right, sum, res, path);
        path.pollLast();
    }
}
