package codetop;

import 每日一题.TreeNode;

/**
 * Title: 重建二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-28
 */
public class 重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build (int[] pre, int preStart, int preEnd,
                            int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int value = pre[preStart];
        int inx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == value) {
                inx = i;
                break;
            }
        }
        int size = inx - inStart + 1;
        TreeNode root = new TreeNode(value);
        root.left = build(pre, preStart + 1, preStart + size, in, inStart, inx - 1);
        root.right = build(pre, preStart + 1 + size, preEnd, in, inx + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        重建二叉树 res = new 重建二叉树();
        System.out.println(res.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).val);
    }
}
