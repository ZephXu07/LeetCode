package codetop;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二叉树的后序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 二叉树的后序遍历 {
//    private List<Integer> res;
//    public List<Integer> postorderTraversal(TreeNode root) {
//        res = new LinkedList<>();
//        dfs(root);
//        return res;
//    }
//
//    private void dfs (TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        dfs(root.left);
//        dfs(root.right);
//        res.add(root.val);
//    }


    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();

        TreeNode pre = new TreeNode();

        while (null != root || !stack.isEmpty()) {
            /*
                往左边走
             */
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            /*
                左边尽头，走右边
             */
            if (null == root.right || root.right == pre) {
                /*
                    右边走不了，即左右都走完了，相当于递归的最后一步加入结果
                    同时 pre 是记录上一次的情况，避免死循环，例如：
                        3
                    9       4
                           5   7
                    到 4 走了一遍，已经从栈中弹出 4 ，此时一看右边还有 7 ，再进去了，死循环了
                 */
                res.add(root.val);
                pre = root;
                /*
                    记录上一步的节点
                 */
                root = null;
                /*
                    清空等栈中再弹出
                 */
            } else {
                /*
                    右边还有得走，走下去，再回头开头情况看看是不是左边能走
                 */
                stack.push(root);
                root = root.right;
            }

        }
        return res;
    }
}
