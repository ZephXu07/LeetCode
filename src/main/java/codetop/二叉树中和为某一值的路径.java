package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉树中和为某一值的路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-19
 */
public class 二叉树中和为某一值的路径 {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(root, track, sum);
        return res;
    }

    private void backTrack(TreeNode root, LinkedList<Integer> track, int sum) {
        if (null == root) {
            return;
        }
        track.add(root.val);
        sum -= root.val;
        if (sum == 0 && null == root.left && null == root.right) {
            res.add(new LinkedList<>(track));
        }
        backTrack(root.left, track, sum);
        backTrack(root.right, track, sum);
        track.removeLast();
    }
}
