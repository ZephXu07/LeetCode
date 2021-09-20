package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 莫里斯中序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-13
 */
public class 莫里斯中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        TreeNode pre = null;
        while(null != root) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if(null != root.left) {
                pre = root.left;
                while(null != pre.right) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //断开连接
            } else {
                //左子树为空，则打印这个节点，并向右边遍历
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
