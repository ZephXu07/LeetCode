package 剑指offer;

import java.util.LinkedList;

/**
 * Title: 二叉搜索树的后序遍历序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int pivot = start;
        while (postorder[pivot] < postorder[end]) {
            pivot++;
        }
        int cur = pivot;
        while (postorder[cur] > postorder[end]) {
            cur ++;
        }
        return cur == end &&
                helper(postorder, start, pivot - 1) &&
                helper(postorder, pivot, end - 1);

    }

    public static void main(String[] args) {
        二叉搜索树的后序遍历序列 res = new 二叉搜索树的后序遍历序列();
        int[] postorder = {1,2,5,10,6,9,4,3};
        System.out.println(res.verifyPostorder(postorder));
        System.out.println(res.verifyPostorderStack(postorder));
    }



    public boolean verifyPostorderStack(int[] postorder) {
        int pre = Integer.MAX_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > pre) {
                return false;
            }
            while (!stack.isEmpty() && stack.getLast() > postorder[i]) {
                pre = stack.removeLast();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
