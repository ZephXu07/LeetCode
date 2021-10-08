package 剑指offer专项突击版;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 二叉搜索树中两个节点之和056
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 二叉搜索树中两个节点之和056 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs (TreeNode root, int k, Set<Integer> set) {
        if (null == root) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }


}
