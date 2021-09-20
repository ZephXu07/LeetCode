package labuladong;

/**
 * Title: labuladong.InsertIntoBST
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left =  insertIntoBST(root.left, val);
        } else {
            root.right =  insertIntoBST(root.right, val);
        }
        return root;
    }
}
