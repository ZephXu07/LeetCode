package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 打家劫舍三
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class 打家劫舍三 {

    private Map<TreeNode, Integer> memo = new HashMap<>();
    //备忘录
    public int robMap(TreeNode root) {
        if (null == root) {
            return 0;
            //空的自然0
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
            //减少重复计算
        }
        int rob = root.val +
                (null == root.left ? 0 : robMap(root.left.left) + robMap(root.left.right)) +
                (null == root.right ? 0 : robMap(root.right.left) + robMap(root.right.right));
        /*抢的话此房间的值，如果左节点不为空，则去抢左节点的左右节点，右节点同理*/
        int notRob = robMap(root.left) + robMap(root.right);
        /*不抢则直接抢左右节点的*/
        int res = Math.max(rob, notRob);
        /*进行大小比较*/
        memo.put(root, res);
        /*存入备忘录*/
        return res;
    }

    public int rob(TreeNode root) {
        int[] res = dp(root);
        //0代表此节点抢了，1则否
        return Math.max(res[0], res[1]);
    }

    private int[] dp (TreeNode root) {
        if (null == root) {
            return new int[] {0, 0};
        }
        int[] left = dp(root.left);
        //左子节点的抢与没抢
        int[] right = dp(root.right);
        //同理

        int rob = root.val + left[1] + right[1];
        //此节点抢了，左右子节点只能选择没抢的

        int notRob = Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]);
        //此节点没抢，左右子节点挑最大的

        return new int[] {rob, notRob};
        //返回
    }


}
