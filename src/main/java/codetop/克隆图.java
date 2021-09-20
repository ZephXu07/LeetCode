package codetop;

import java.util.*;

/**
 * Title: 克隆图
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-29
 */
public class 克隆图 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node start = new Node(node.val);
        map.put(node.val, start);

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (set.contains(tmp.val)) {
                continue;
            }
            Node newNode;
            if (map.containsKey(tmp.val)) {
                newNode = map.get(tmp.val);
            } else {
                newNode = new Node(tmp.val);
            }

            for (Node n : tmp.neighbors) {
                queue.offer(n);

                Node nei;
                if (map.containsKey(n.val)) {
                    nei = map.get(n.val);
                    newNode.neighbors.add(nei);
//                    nei.neighbors.add(newNode);
                } else {
                    nei = new Node(n.val);
                    newNode.neighbors.add(nei);
//                    nei.neighbors.add(newNode);
                    map.put(n.val, nei);
                }
            }
            set.add(tmp.val);

        }
        return start;
    }
}
