package 杂类;

import 每日一题.TreeNode;

/**
 * Title: 监控二叉树968
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-19
 */
public class 监控二叉树968 {
    private static final int UNCOVERED = 0;
    /*
        节点没有被覆盖
     */
    private static final int CAMERA = 1;
    /*
        节点有摄像头
     */
    private static final int COVERED = 2;
    /*
        节点被覆盖
     */

    private int res;
    public int minCameraCover(TreeNode root) {
        res = 0;
        if (UNCOVERED == postOrder(root)) {
            /*
                后序遍历后的 root 节点是没被覆盖的情况
                他自身需要安装摄像头
                因为其上面没有节点了
             */
            res++;
        }
        return res;
    }

    private int postOrder (TreeNode root) {
        /*
            https://leetcode-cn.com/problems/binary-tree-cameras/submissions/
         */
        if (null == root) {
            return COVERED;
            /*
                空节点设置为被覆盖的
                因为空节点有摄像头是不可能的事，
                空节点设置被覆盖好让叶子节点设置为没有被覆盖
                从而使叶子节点的父结点设置摄像头来覆盖叶子节点
                贪心思想
             */
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        /*
            因为需要知道左右子节点的状态才好判断父结点需要什么状态
         */
        if (left == COVERED && right == COVERED) {
            /*
                左、右子节点是被覆盖的，
                使用贪心思想，父结点是没有被覆盖的，等待父结点的父结点装摄像头来覆盖
             */
            return UNCOVERED;
        }

        if (left == UNCOVERED || right == UNCOVERED) {
            /*
                如果左子节点没覆盖或者右子节点没覆盖或者都没覆盖
                则父结点需要安装摄像头来进行覆盖
                因此摄像头增加
                此一步需要先与安装摄像头
                因为可能有一处安装了摄像头而造成了另外节点没被覆盖
             */
            res++;
            return CAMERA;
        }

        if (left == CAMERA || right == CAMERA) {
            /*
                如果左子节点安装了摄像头或者右子节点安装了摄像头
                或者都安装了摄像头
                则父结点被覆盖了
             */
            return COVERED;
        }


        /*
            此处是没走到的地方，
            只是为了上面的方便分类
         */
        return -1;
    }
}
