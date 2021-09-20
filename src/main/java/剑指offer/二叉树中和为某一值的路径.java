package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉树中和为某一值的路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-04
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
        sum += root.val;
    }

    public static void main(String[] args) {
        二叉树中和为某一值的路径 res = new 二叉树中和为某一值的路径();

        序列化二叉树 tree = new 序列化二叉树();
        String s = "-2_N_-3_N_N";
        TreeNode root = tree.deserialize(s);
        List<List<Integer>> lists = res.pathSum(root, -5);
        for (List<Integer> l: lists) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
