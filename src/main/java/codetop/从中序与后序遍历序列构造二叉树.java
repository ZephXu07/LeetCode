package codetop;

import 每日一题.TreeNode;

/**
 * Title: 从中序与后序遍历序列构造二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-13
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
        /*
            3
          9   20
            15    7
           中序 9,3,15,20,7
           后序 9,15,7,20,3

           后序从右往左的每个值是根节点，，然后右节点，左节点，
           包含整棵树的父结点，有一个或两个子节点的节点，甚至无子节点的节点
           而找到根节点后，在中序中，此根节点的左右边是其的左右子树

           如 3 对应的是父结点，其左子树包含 9，右子树包含 15 20 7
           20 对应的是3的由节点 的右子树，其左子树包含 15，右子树包含 7
           7， 15 ，9 是无子节点的节点，又中序和后序的 start、end 的大小，
           如果 start == end 即是它们
           如果 start < end 即它们没有子节点

     */
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        int rightSize = inEnd - index;
        root.right = build(postorder, postEnd - rightSize, postEnd - 1,
                inorder, index + 1, inEnd);
        root.left = build(postorder, postStart, postEnd - rightSize - 1,
                inorder, inStart, index - 1);
        return root;
    }
}
