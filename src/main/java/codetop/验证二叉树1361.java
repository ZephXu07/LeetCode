package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 验证二叉树1361
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 验证二叉树1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) {
            return leftChild[0] == -1 && rightChild[0] == -1;
            /*
                特例，打补丁时出现的，懒得删
             */
        }
        Map<Integer, Integer> child = new HashMap<>(n);
        /*
            子节点 -- > 父结点
         */
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if ((left != -1 && left == right) || (left == i || right == i)) {
                /*
                    左右子节点不为空且相同，错误
                    左右子节点是自身，错误
                 */
                return false;
            }
            if (child.containsKey(left) || child.containsKey(right)) {
                /*
                    只有一个父结点，否则错误
                 */
                return false;
            }
            if (left != -1) {
                /*
                    左节点不为空且左节点不是父结点的某个祖节点，否则错误
                 */
                if (isValid(child, i, left)) {
                    child.put(left, i);
                } else {
                    return false;
                }

            }
            if (right != -1) {
                /*
                    同理
                 */
                if (isValid(child, i, right)) {
                    child.put(right, i);
                } else {
                    return false;
                }
            }

        }
        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            /*
                只能有一个根节点
                即节点没有父结点的节点只有一个
             */
            if (!child.containsKey(i) ) {
                rootCount++;
            }

        }
        return rootCount == 1;
    }

    private boolean isValid (Map<Integer, Integer> child, int cur, int hope) {
        /*
            判断其子节点是不是其祖先节点
         */
        while (child.containsKey(cur)) {
            int tmp = child.get(cur);
            if (tmp == hope) {
                return false;
            }
            cur = tmp;
        }
        return true;
    }

    public static void main(String[] args) {
        验证二叉树1361 res = new 验证二叉树1361();
//        int n = 5;
//        int[] left = {1,-1,3,4,-1};
//        int[] right = {-1,2,-1,-1,-1};
//        // true
        int n = 4;
        int[] left = {1,2,0,-1};
        int[] right = {-1,-1,-1,-1};
        // false
        System.out.println(res.validateBinaryTreeNodes(n, left, right));
    }
}
