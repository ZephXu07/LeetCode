package codetop;

import java.util.List;

/**
 * Title: N叉树的最大深度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class N叉树的最大深度 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        if (null == root.children) {
            return 1;
        }
        int max = 1;
        for (Node n : root.children) {
            max = Math.max(maxDepth(n) + 1, max);
        }
        return max;
    }


}
