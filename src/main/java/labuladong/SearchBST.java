package labuladong;

/**
 * Title: labuladong.SearchBST
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
