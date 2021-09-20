package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 叶子相似的树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-10
 */
public class 叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        dfs(root1, list1);
        List<Integer> list2 = new LinkedList<>();
        dfs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs (TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
