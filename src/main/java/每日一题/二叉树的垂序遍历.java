package 每日一题;

import 工具类.树;

import java.util.*;

/**
 * Title: 二叉树的垂序遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-31
 */
public class 二叉树的垂序遍历 {
    private List<int[]> coor;
    private Map<int[], Integer> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        coor = new ArrayList<>();
        map = new HashMap<>();
        dfs(root, 0, 0);
        coor.sort((c1, c2) -> {
            /*
                y轴、x轴、值
             */
            if (c1[1] == c2[1]) {
                if (c1[0] == c2[0]) {
                    return map.get(c1) - map.get(c2);
                }
                return c1[0] - c2[0];
            }
            return c1[1] - c2[1];
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(map.get(coor.get(0)));
        res.add(tmp);
        for (int i = 1; i < coor.size(); i++) {
            int[] c = coor.get(i);
            if (c[1] == coor.get(i - 1)[1]) {
                tmp = res.get(res.size() - 1);
                tmp.add(map.get(c));
            } else {
                tmp = new ArrayList<>();
                tmp.add(map.get(c));
                res.add(tmp);
            }
        }
        return res;
    }

    private void dfs (TreeNode root, int x, int y) {
        if (null == root) {
            return;
        }
        int[] tmp = new int[]{x, y};
        coor.add(tmp);
        map.put(tmp, root.val);
        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }

    public static void main(String[] args) {
        二叉树的垂序遍历 res = new 二叉树的垂序遍历();
        String data = "1_2_3_4_6_5_7";
        TreeNode tree = 树.buildTree(data);
        List<List<Integer>> lists = res.verticalTraversal(tree);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
