package 剑指offer;


import java.util.HashMap;
import java.util.Map;

/**
 * Title: 重建二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 重建二叉树 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, 0, preorder.length - 1,
//                inorder, 0, inorder.length - 1);
//    }
//
//    private TreeNode build(int[] preorder, int preStart, int preEnd,
//                           int[] inorder, int inStart, int inEnd) {
//        if (preStart > preEnd) {
//            return null;
//        }
//        int value = preorder[preStart];
//        TreeNode root = new TreeNode(value);
//        int rootIndex = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (value == inorder[i]) {
//                rootIndex = i;
//            }
//        }
//        int leftSize = rootIndex - inStart;
//        root.left = build(preorder, preStart + 1, preStart + leftSize,
//                inorder, inStart, rootIndex - 1);
//        root.right = build(preorder, preStart + leftSize + 1, preEnd,
//                inorder, rootIndex + 1, inEnd);
//        return root;
//    }

    private int[] preorder;
    private Map<Integer, Integer> memo = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            memo.put(inorder[i], i);
        }
        return builde(0, 0, preorder.length - 1);
    }

    private TreeNode builde(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = memo.get(preorder[root]);
        node.left = builde(root + 1, left, i - 1);
        node.right = builde(root + i - left + 1, i + 1, right);
        return node;
    }

    public static void main(String[] args) {
        重建二叉树 tree = new 重建二叉树();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = tree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
