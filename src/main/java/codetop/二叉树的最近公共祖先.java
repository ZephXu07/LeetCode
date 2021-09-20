package codetop;

import 每日一题.TreeNode;

/**
 * Title: 二叉树的最近公共祖先
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*
            lowestCommonAncestor 函数功能重新定义一下
            1. 如果 p 和 q 都存在，则返回它们的公共祖先；
            2. 如果只存在一个，则返回存在的一个；
            3. 如果 p 和 q 都不存在，则返回NULL


             lowestCommonAncestor这个函数不要理解为找公共祖先，
             而就理解为帮两个节点找祖先 传入的值是root, p, q，帮p和q找到一个祖先就行，
             找到两个就更好了，如果找不到就返回NULL

             在root->left里面找一次，找到 p 的祖先
             root->right里面再找一次，找到 q 的祖先

             如果某一边返回值是NULL， 那么说明两个值都在另一边，即他们在祖先都在同一边
             由于找的时候，一定是找的最近的祖先返回，所以这里直接返回前面的返回值就行了，
             可以保证是最近的公共祖先
             如果左右的返回值都不是NULL，那说明p的祖先和q的祖先分别在两边，则当前节点就是最近公共祖先
                 （设节点 root为节点p,q 的某公共祖先，若其左子节点 root.left
                 和右子节点 root.righ 都不是p,q 的公共祖先，
                 则称 root是 “最近的公共祖先” 。）

             左右都找不到就直接返回NULL

         */

        /*
            情况 1
         */
        if (left != null && right != null) {
            return root;
        }
        /*
            情况 3
         */
        if (left == null && right == null) {
            return null;
        }
        /*
            情况 2
         */
        return left == null ? right : left;
    }
}
