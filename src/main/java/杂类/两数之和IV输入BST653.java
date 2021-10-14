package 杂类;

import 每日一题.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 两数之和IV输入BST653
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-14
 */
public class 两数之和IV输入BST653 {
    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return find(root, target, new HashSet<>());
    }

    private boolean find(TreeNode node, int target, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(target - node.val)) {
            return true;
        }
        set.add(node.val);
        return find(node.left, target, set) || find(node.right, target, set);
    }

}
