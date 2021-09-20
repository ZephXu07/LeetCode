package codetop;

import 每日一题.TreeNode;
import 每日一题.用Rand7实现Rand10;

/**
 * Title: 删除二叉搜索树中的节点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-19
 */
public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }

        if (root.val < key) {
            /*
                比根节点大，进入右节点处理
             */
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            /*
                比根节点大，进入左节点处理
             */
            root.left = deleteNode(root.left, key);
            return root;
        }

        /*
            到此处一定是 root.val == key
         */
        if (null == root.left && null == root.right) {
            /*
                此根节点是叶子节点，直接返回空
             */
            return null;
        }

        if (null == root.left) {
            /*
                此节点左节点是空的，直接返回右节点
                节点的右节点置空
             */
            TreeNode right = root.right;
            root.right = null;
            return right;
        }

        if (null == root.right) {
            /*
                此节点右节点是空的，直接返回左节点
                节点的左节点置空
             */
            TreeNode left = root.left;
            root.left = null;
            return left;
        }

        TreeNode min = getMin(root.right);
        /*
            找到此节点的右节点中最小的数
         */
        TreeNode minCopy = new TreeNode(min.val);
        /*
            创建新的节点，赋值上述找到的最小值
         */
        minCopy.left = root.left;
        /*
            左指针指向原节点的左节点
         */
        minCopy.right = removeMin(root.right);
        /*
            右指针指向 删除了上述最小值节点的右子树
         */
        root.left = null;
        root.right = null;
        /*
            被删除的节点的左右指针置空
         */



        return minCopy;
        /*
            返回新创建的节点
         */
    }

    private TreeNode getMin (TreeNode root) {
        /*
            找到最小值的节点，
            根据二叉搜索树的性质
            直到最左的节点
         */
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

    private TreeNode removeMin (TreeNode root) {
        if (null == root.left) {
            /*
                在递归中找到了最小值的节点
                因为其左节点是空，则他是最小左节点

             */
            TreeNode right = root.right;
            /*
                其右节点需要保存起来
                作为此节点的父结点的新左子树
             */
            root.right = null;
            /*
                最小节点的右指针置空
             */
            return right;
            /*
                返回此节点的父结点的新左子树
             */
        }
        root.left = removeMin(root.left);
        /*
            找到最小的左节点，并连接新的左子树
         */
        return root;
        /*
            返回此父结点
         */
    }
}
