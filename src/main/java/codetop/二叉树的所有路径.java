package codetop;

import 每日一题.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 二叉树的所有路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 二叉树的所有路径 {
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return res;
    }

    private void dfs (TreeNode root, StringBuilder builder) {
        if (builder.length() == 0) {
            builder.append(root.val);
        } else {
            builder.append("->").append(root.val);
        }
        if (null == root.left && null == root.right) {
            res.add(builder.toString());
            return;
        }
        if (null != root.left) {
            dfs(root.left, new StringBuilder(builder));
        }
        if (null != root.right) {
            dfs(root.right, new StringBuilder(builder));
        }
    }
}
