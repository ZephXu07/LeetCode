package labuladong;

/**
 * Title: labuladong.KthSmallest
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-25
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        System.out.print(root.val + "\t");
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallest k = new KthSmallest();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println();
        System.out.println(k.kthSmallest(root, 1));
//        System.out.println(k.kthSmallest(root, 2));
//        System.out.println(k.kthSmallest(root, 3));
//        System.out.println(k.kthSmallest(root, 4));

    }

}
