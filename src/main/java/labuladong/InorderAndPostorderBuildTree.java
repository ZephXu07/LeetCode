package labuladong;

/**
 * Title: labuladong.InorderAndPostorderBuildTree
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-24
 */
public class InorderAndPostorderBuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
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


    public static void main(String[] args) {
        int[] preorder = {9,3,15,20,7};
        int[] inorder = {9,15,7,20,3};
        InorderAndPostorderBuildTree buildTree = new InorderAndPostorderBuildTree();
        TreeNode tree = buildTree.buildTree(preorder, inorder);
        System.out.println(tree.val);
    }
}
