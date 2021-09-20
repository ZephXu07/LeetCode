package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * Title: 序列化和反序列化N叉树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 序列化和反序列化N叉树 {

    public String serialize(Node root) {
        /*
        序列化：将N叉树前序遍历，每个子树由[]表示
        如题目中给出的示例序列化后变为：
     */
        /*
            前序遍历
         */
        if (null == root) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }


    private void dfs(Node root, StringBuilder builder) {
        /*
        前序遍历
     */
        if (null == root) {
            return;
        }
        builder.append("[");
        builder.append(root.val);
        if (null != root.children) {
            builder.append(" ");
            for(Node node : root.children){
                dfs(node,builder);
            }
        }
        builder.append("]");
    }

    public Node deserialize(String data) {
        /*
            [1 [3[5 6] 2 4]]
            创建一个栈用来保存节点。遍历字符串，如果出现数字，则创建新节点，
            如果栈不为空，则获取顶层元素，
            加入顶层元素的child中，然后压栈。
            如果遇到']'则弹栈，直至遍历完字符串。
            树的元素没有负数，则不需要考虑别的情况。

         */
        if (null == data || data.length() == 0) {
            return null;
        }

        /*
            把前后的无关 [] 删了
         */
        Deque<Node> stack = new LinkedList<>();
        for (int i = 1; i < data.length() - 1; ){
            if (data.charAt(i) >= '0'&&data.charAt(i) <= '9') {
                StringBuilder tmp = new StringBuilder();
                while (i < data.length() && data.charAt(i) >= '0' && data.charAt(i) <= '9') {
                    tmp.append(data.charAt(i));
                    i++;
                }
                /*
                    一个完整数字
                 */
                int cur = Integer.parseInt(tmp.toString());
                Node t = new Node(cur,new ArrayList<>());
                /*
                    不为root节点
                 */
                if (!stack.isEmpty()) {
                    /*
                        栈不为空说明有父节点
                     */
                    Node par = stack.peek();
                    if(null == par.children){
                        par.children = new ArrayList<>();
                    }
                    par.children.add(t);
                }
                stack.push(t);
                /*
                    成为某些节点的父结点
                 */
            }
            if (i < data.length() && data.charAt(i) == ']') {
                /*
                    一棵子树遍历完
                 */
                stack.pop();
            }
            i++;
        }
        /*
            因为根节点没有父结点
            所以栈为空，说明树不成立
            不为空返回根节点
         */
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }



    static class Node {
        public int val;
        public List<Node> children;
        public Node () {

        }
        public Node (int val) {
            this.val = val;
        }

        public Node (int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

    }


    public static void main(String[] args) {
        序列化和反序列化N叉树 res = new 序列化和反序列化N叉树();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> l1 = new LinkedList<>();
        l1.add(node2);
        l1.add(node3);
        l1.add(node4);
        node1.children = l1;
        List<Node> l2 = new LinkedList<>();
        l2.add(node5);
        l2.add(node6);
        node3.children = l2;

        String d = res.serialize(node1);
        System.out.println(d);
        Node deserialize = res.deserialize(d);
        System.out.println(deserialize);
    }

}
