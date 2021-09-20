package codetop;

import 每日一题.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 恢复二叉搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 恢复二叉搜索树 {
//    public void recoverTree(TreeNode root) {
//        List<TreeNode> list = new LinkedList<>();
//        inorder(list, root);
//        /*
//            中序遍历
//            保存结果
//            找到第一个转折点，即 i - 1 > i
//            保存 i - 1 = x
//            再后续遍历找到 i - 1 > i
//            保存 i = y
//            交换 x 、 y
//         */
//        TreeNode x = null;
//        TreeNode y = null;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).val < list.get(i - 1).val) {
//                y = list.get(i);
//                if (null == x) {
//                    x = list.get(i - 1);
//                }
//            }
//        }
//        int tmp = x.val;
//        x.val = y.val;
//        y.val = tmp;
//    }
//
//    private void inorder (List<TreeNode> list, TreeNode cur) {
//        if (null == cur) {
//            return;
//        }
//
//        inorder(list, cur.left);
//
//        list.add(cur);
//
//        inorder(list, cur.right);
//
//    }

    private TreeNode pre;
    private TreeNode x;
    private TreeNode y;
    public void recoverTree(TreeNode root) {
        pre = null;
        x = null;
        y = null;

        inorder(root);

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;

    }

    private void inorder (TreeNode cur) {
        if (null == cur) {
            return;
        }

        inorder(cur.left);

        if (null == pre) {
            pre = cur;
        } else {
            if (cur.val < pre.val) {
                y = cur;
                if (null == x) {
                    x = pre;
                }
            }
            pre = cur;
        }

        inorder(cur.right);
    }


}
