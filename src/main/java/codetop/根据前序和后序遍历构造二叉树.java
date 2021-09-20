package codetop;

import 工具类.树;
import 每日一题.TreeNode;

import java.util.Arrays;

/**
 * Title: 根据前序和后序遍历构造二叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        return build(preorder, postorder);

        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

//    private TreeNode build (int[] pre, int[] post) {
//        /*
//            前序遍历
//                根     左子树               右子树
//                         |                   |
//                         |                   |
//                    根 左子树 右子树     根  左子树  右子树
//                    ......
//            后序遍历
//                        左子树             右子树             根
//                          |                 |
//                          |                 |
//                  左子树  右子树  根      左子树  右子树  根
//                    ......
//            pre[0] 是根， pre[1]是左子树的根，
//            在 post[] 找打 pre[1] 即找到了左子树的范围 [0, inx(pre[1])]，剩下的到 post[len-2]即是右子树
//            找到左子树的大小，即在 pre[] 中标出左子树，剩下的即是右子树
//
//            使用函数复制出新的preLeft,postLeft ，建造出左子树
//            用函数复制出新的preRight,postRight ，建造出左子树
//            不断递归下去则完成了
//
//         */
//        if (pre.length == 0) {
//            return null;
//        }
//
//        if (pre.length == 1) {
//            return new TreeNode(pre[0]);
//        }
//
//        TreeNode root = new TreeNode(pre[0]);
//
//        for (int i = 0; i < post.length; i++) {
//            if (post[i] == pre[1]) {
//                int leftSize = i + 1;
//                int[] preLeft = Arrays.copyOfRange(pre, 1, leftSize + 1);
//                int[] preRight = Arrays.copyOfRange(pre, leftSize + 1, pre.length);
//                int[] postLeft = Arrays.copyOfRange(post, 0, leftSize);
//                int[] postRight = Arrays.copyOfRange(post, leftSize, post.length - 1);
//
//                root.left = build(preLeft, postLeft);
//                root.right = build(preRight, postRight);
//                break;
//            }
//        }
//        return root;
//
//
//    }

    private TreeNode build (int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == pre[preStart + 1]) {
                int len = i - postStart + 1;
                root.left = build(pre, preStart + 1, preStart + len,
                        post, postStart, i);
                root.right = build(pre, preStart + len + 1, preEnd,
                        post, i + 1, postEnd - 1);
                break;
            }
        }

        return root;

    }


    public static void main(String[] args) {
        根据前序和后序遍历构造二叉树 res = new 根据前序和后序遍历构造二叉树();
        final TreeNode treeNode = res.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(树.levelTraverse(treeNode));
    }
}
