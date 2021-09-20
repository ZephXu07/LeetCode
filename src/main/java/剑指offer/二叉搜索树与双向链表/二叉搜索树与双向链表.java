package 剑指offer.二叉搜索树与双向链表;

import 剑指offer.二叉搜索树与双向链表.Node;

/**
 * Title: 二叉搜索树与双向链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 二叉搜索树与双向链表 {



    private Node pre;
    private Node head;
    public Node treeToDoublyList(Node root) {
        pre = null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node cur) {
        if (null == cur) {
            return ;
        }
        dfs(cur.left);
        if (null == pre) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        二叉搜索树与双向链表 res = new 二叉搜索树与双向链表();
        Node list = res.treeToDoublyList(root);
        System.out.println(list);
    }
}
