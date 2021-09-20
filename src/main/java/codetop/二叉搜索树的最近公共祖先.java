package codetop;

import 每日一题.TreeNode;

import java.util.*;

/**
 * Title: 二叉搜索树的最近公共祖先
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 二叉搜索树的最近公共祖先 {
//    private Map<TreeNode, TreeNode> map;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        map = new HashMap<>();
//        findParent(root, root);
//        TreeNode m = p;
//        TreeNode n = q;
//        while (m != root) {
//            while (n != m && n != root) {
//                n = map.get(n);
//            }
//            if (n == root) {
//                m = map.get(m);
//                n = q;
//            } else {
//                return n;
//            }
//        }
//        return root;
//    }
//
//    private void findParent (TreeNode node, TreeNode parent) {
//        if (null == node) {
//            return;
//        }
//        map.put(node, parent);
//        findParent(node.left, node);
//        findParent(node.right, node);
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            二叉搜索树的性质
            root > p && root > q
            证明 p q 都在 root 的左子树
            root < p && root < q
            证明 p q 都在 root 的右子树
            否则其他情况如
                root > p , root < q
                p在左子树，q在右子树，root是最近公共祖先
                root < p, root > q 同理

                root = p, root > q || root < q || 则root = p 是最近公共祖先

                同理 root = q, root > p || root < p || 则root = q是最近公共祖先
         */
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

}
