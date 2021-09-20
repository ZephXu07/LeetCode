package 每日一题;

import java.util.*;

/**
 * Title: 自由之路
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-22
 */
public class 自由之路 {
    private Map<Character, List<Integer>> mapping;
    // 字符 -> 索引列表
    private int[][] memo;
    // 备忘录
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length();
        int kLen = key.length();
        memo = new int[rLen][kLen];
        mapping = new HashMap<>();
        for (int i = 0; i < rLen; i++) {
            char c = ring.charAt(i);
            if (mapping.containsKey(c)) {
                List<Integer> tmp = mapping.get(c);
                tmp.add(i);
            } else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(i);
                mapping.put(c, tmp);
            }
        }
        // 记录圆环上字符到索引的映射
        return dp(ring, 0, key, 0);
        // 圆盘指针最初指向 12 点钟方向，
        // 从第一个字符开始输入 key
    }


    private int dp(String ring, int i, String key, int j) {
        // 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
        if (j == key.length()) {
            return 0;
        }
        // base case 完成输入
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        // 查找备忘录，避免重叠子问题
        int rLen = ring.length();
        int res = Integer.MAX_VALUE;
        for (Integer integer : mapping.get(key.charAt(j))) {
            // 做选择
            // ring 上可能有多个字符 key[j]
            int delta = Math.abs(integer - i);
            // 拨动指针的次数
            delta = Math.min(delta, rLen - delta);
            // 选择顺时针还是逆时针
            int subProblem = dp(ring, integer, key, j + 1);
            // 将指针拨到 ring[integer]，继续输入 key[j+1..]
            res = Math.min(res, 1 + subProblem + delta);
            // PS：加一是因为按动按钮也是一次操作
        }
        memo[i][j] = res;
        // 将结果存入备忘录
        return res;
    }


    public static void main(String[] args) {
        自由之路 load = new 自由之路();
        String ring = "godding";
        String key = "godding";
        System.out.println(load.findRotateSteps(ring, key));
    }
}
