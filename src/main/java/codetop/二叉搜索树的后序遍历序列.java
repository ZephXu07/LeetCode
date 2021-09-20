package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 二叉搜索树的后序遍历序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 二叉搜索树的后序遍历序列 {
//    public boolean verifyPostorder(int[] postorder) {
//        return helper(postorder, 0, postorder.length - 1);
//        /*
//            左右中
//         */
//    }
//    private boolean helper(int[] postorder, int start, int end) {
//        /*
//            后序遍历中在后面的是根节点
//            又二叉搜索树根节点大于左节点小于右节点
//         */
//         if (start >= end) {
//             /*
//                当数组遍历完返回true
//              */
//             return true;
//         }
//         int pivot = start;
//         while (postorder[pivot] < postorder[end]) {
//             /*
//                比根节点小的左子树节点
//              */
//             pivot++;
//         }
//         int cur = pivot;
//         while (postorder[cur] > postorder[end]) {
//             /*
//                比根节点大的右子树节点
//              */
//             cur ++;
//         }
//         if (cur == end) {
//             /*
//                二叉搜索树的性质决定，所以最后遍历的点需要是根节点
//                不是则错误
//              */
//             if (helper(postorder, start, pivot - 1)) {
//                 /*
//                    搜索左子树
//                  */
//                 return helper(postorder, pivot, end - 1);
//                 /*
//                    搜索右子树
//                  */
//             }
//         }
//         return false;
////         return cur == end &&
////                 helper(postorder, start, pivot - 1) &&
////                 helper(postorder, pivot, end - 1);
//    }

    public boolean verifyPostorder(int[] postorder) {
        /*
            左子树 --> 右子树 --> 根节点
            左 < 右 > 根
            使用栈从数组末尾遍历，
            从小到大先存储，即存储了根 + 右子树
            此时出现了比栈顶还小的节点，
            说明是左子树了，于是将栈顶弹出
            最后一个弹出的（空栈或者剩下的比此数还小）
            是此左子树的根，记为 pre
            左子树就应该全部小于 pre，否则不是二叉搜索树
            直到进入左子树的新子树，找到新的子树的左子节点
            再弹出新根节点
            直到遍历完数组
         */
        int pre = Integer.MAX_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > pre) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                pre = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
