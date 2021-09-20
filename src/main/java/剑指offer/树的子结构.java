package 剑指offer;

/**
 * Title: 树的子结构
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A || A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
