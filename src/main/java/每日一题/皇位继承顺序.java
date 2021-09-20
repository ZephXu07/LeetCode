package 每日一题;

import java.util.*;

/**
 * Title: 皇位继承顺序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-20
 */
public class 皇位继承顺序 {
}
class ThroneInheritance {
    private class TreeNode {
        private String name;
        private boolean isLive;
        private List<TreeNode> children;
        public TreeNode () {}
        public TreeNode (String name) {
            children = new ArrayList<>();
            this.name = name;
            isLive = true;
        }
        public String getName () {
            return name;
        }

        public boolean isLive () {
            return isLive;
        }

        public void death() {
            isLive = false;
        }

        public void addChild (TreeNode child) {
            children.add(child);
        }

        public List<TreeNode> getChildren () {
            return children;
        }

    }

    private TreeNode root;
    private List<String> order;
    private Map<String, TreeNode> mapping;
    public ThroneInheritance(String kingName) {
        root = new TreeNode("root");
        root.death();
        TreeNode king = new TreeNode(kingName);
        root.addChild(king);
        order = new LinkedList<>();
        mapping = new HashMap<>();
        mapping.put(kingName, king);
    }


    private void dfs (TreeNode node) {
        if (null == node) {
            return;
        }
        if (node.isLive) {
            order.add(node.getName());
        }
        for (TreeNode child : node.getChildren()) {
            dfs(child);
        }
    }

    public void birth(String parentName, String childName) {
        TreeNode parent = mapping.get(parentName);
        TreeNode child = new TreeNode(childName);
        parent.addChild(child);
        mapping.put(childName, child);
    }

    public void death(String name) {
        TreeNode node = mapping.get(name);
        node.death();
    }

    public List<String> getInheritanceOrder() {
        order.clear();
        dfs(root);
        return order;
    }
}
