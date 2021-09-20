package 每日一题;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 验证二叉树的前序序列化
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-12
 */
public class 验证二叉树的前序序列化 {
//    private boolean flag;
//    public boolean isValidSerialization(String preorder) {
//        flag = true;
//        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(preorder.split(",")));
//        deserialize(nodes);
//        return flag && nodes.isEmpty();
//    }
//
//    private TreeNode deserialize(LinkedList<String> nodes) {
//        if (nodes.isEmpty()) {
//            return null;
//        }
//        String first = nodes.removeFirst();
//        if ("#".equals(first)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(first));
//        if (nodes.isEmpty()) {
//            flag = false;
//        }
//        root.left = deserialize(nodes);
//        if (nodes.isEmpty()) {
//            flag = false;
//        }
//        root.right = deserialize(nodes);
//        return root;
//    }

//    public boolean isValidSerialization(String preorder) {
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(1);
//        int inx = 0;
//        char c;
//        while (inx < preorder.length()) {
//            if (stack.isEmpty()) {
//                return false;
//            }
//            c = preorder.charAt(inx);
//            int top = stack.pop() - 1;
//            if (top > 0) {
//                stack.push(top);
//            }
//            if (c != '#') {
//                while (inx < preorder.length() && preorder.charAt(inx) != ',') {
//                    inx++;
//                }
//                inx--;
//                stack.push(2);
//            }
//            inx += 2;
//        }
//        return stack.isEmpty();
//    }

    public boolean isValidSerialization(String preorder) {
        int count = 1;
        int inx = 0;
        char c;
        while (inx < preorder.length()) {
            if (count == 0) {
                return false;
            }
            c = preorder.charAt(inx);
            count--;
            if (c != '#') {
                while (inx < preorder.length() && preorder.charAt(inx) != ',') {
                    inx++;
                }
                inx--;
                count += 2;
            }
            inx += 2;
        }
        return count == 0;
    }


    public static void main(String[] args) {
        验证二叉树的前序序列化 res = new 验证二叉树的前序序列化();
//        String preorder1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String preorder2 = "1,#";
//        String preorder3 = "9,#,#,1";
        String preorder4 = "9,#,92,#,#";
//        System.out.println(res.isValidSerialization(preorder1));
//        System.out.println(res.isValidSerialization(preorder2));
//        System.out.println(res.isValidSerialization(preorder3));
        System.out.println(res.isValidSerialization(preorder4));
    }
}
