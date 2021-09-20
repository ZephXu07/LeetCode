package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 二叉搜索树的最近公共祖先
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-08
 */
public class 二叉搜索树的最近公共祖先 {
    private Map<TreeNode, TreeNode> memo;
    private TreeNode p;
    private TreeNode q;
    public TreeNode lowestCommonAncestorMy(TreeNode root, TreeNode p, TreeNode q) {
        memo = new HashMap<>();
        this.p = p;
        this.q = q;
        memo.put(root, root);
        helper(root);
        TreeNode pParent = p;
        TreeNode qParent = q;
        while (pParent != root) {
            qParent = q;
            while (qParent != root) {
                if (qParent == pParent) {
                    return qParent;
                }
                qParent = memo.get(qParent);
            }
            pParent = memo.get(pParent);
        }
        return pParent;
    }

    private void helper(TreeNode parent) {
        if (memo.containsKey(p) && memo.containsKey(q)) {
            return;
        }
        if (null != parent.left) {
            memo.put(parent.left, parent);
            helper(parent.left);
        }
        if (null != parent.right) {
            memo.put(parent.right, parent);
            helper(parent.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (null != root) {
            if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode tree = new TreeNode(6);
//        tree.left = new TreeNode(2);
//        TreeNode p = tree.left;
//        tree.left.left = new TreeNode(0);
//        tree.left.right = new TreeNode(4);
//        tree.left.right.left = new TreeNode(3);
//        tree.left.right.right = new TreeNode(5);
//        tree.right = new TreeNode(8);
//        TreeNode q = tree.right;
//        tree.right.left = new TreeNode(7);
//        tree.right.right = new TreeNode(9);
        二叉搜索树的最近公共祖先 res = new 二叉搜索树的最近公共祖先();
//        System.out.println(res.lowestCommonAncestorMy(tree, p, q).val);
//        System.out.println(res.lowestCommonAncestor(tree, p, q).val);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        res.pre(root);

        System.out.println();
        res.in(root);
        System.out.println();
        res.post(root);
    }


    private void pre(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + "\t");
        pre(root.left);
        pre(root.right);
    }


    private void in(TreeNode root) {
        if (null == root) {
            return;
        }
        in(root.left);
        System.out.print(root.val + "\t");
        in(root.right);
    }

    private void post(TreeNode root) {
        if (null == root) {
            return;
        }
        post(root.left);
        post(root.right);
        System.out.print(root.val + "\t");
    }
}
