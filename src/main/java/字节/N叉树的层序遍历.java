package 字节;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: N叉树的层序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                level.add(tmp.val);
                for (Node n : tmp.children) {
                    queue.offer(n);
                }
            }
            res.add(level);
        }
        return res;
    }
}
