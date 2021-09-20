package labuladong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: labuladong.FindDuplicateSubtrees
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class FindDuplicateSubtrees {
//    private Map<String, Integer> memo = new HashMap<>();
//    private List<labuladong.TreeNode> res = new ArrayList<>();
//    public List<labuladong.TreeNode> findDuplicateSubtrees(labuladong.TreeNode root) {
//        traverse(root);
//        return res;
//    }
//
//    private String traverse(labuladong.TreeNode root) {
//        if (null == root) {
//            return "N";
//        }
//        String left = traverse(root.left);
//        String right = traverse(root.right);
//        String tree = root.val + "_" + left + "_" + right;
//        int count = memo.getOrDefault(tree, 0);
//        if (1 == count) {
//            res.add(root);
//        }
//        memo.put(tree, count + 1);
//        return tree;
//    }

    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }
}
