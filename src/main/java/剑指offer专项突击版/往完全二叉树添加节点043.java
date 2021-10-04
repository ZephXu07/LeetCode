package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 往完全二叉树添加节点043
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 往完全二叉树添加节点043 {
}
class CBTInserter {

    private List<TreeNode> list;

    public CBTInserter(TreeNode root) {
        list = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int insert(int v) {

        TreeNode node = new TreeNode(v);

        list.add(node);

        TreeNode parent = list.get(list.size() / 2 - 1);

        if(parent.left == null){
            parent.left = node;
        }else {
            parent.right = node;
        }

        return parent.val;
    }

    public TreeNode get_root() {

        return list.get(0);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}
