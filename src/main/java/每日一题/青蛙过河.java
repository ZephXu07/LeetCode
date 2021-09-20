package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 青蛙过河
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-29
 */
public class 青蛙过河 {

    private Map<Integer, Integer> map;
    //记录河流第stones[i]个格子是石头，是第 (i + 1) 个石头
    private Map<String, Boolean> res;
    //记录第 (i + 1) 个石头，是否跳 dis 步可以到达
    public boolean canCrossDfs(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        //按照题意第一部只能走1，而出发点永远是坐标为0的石头，所以第二块石头坐标必须是1
        map = new HashMap<>();
        res = new HashMap<>();
        int len = stones.length;
        for (int i = 0; i < len; i++) {
            map.put(stones[i], i);
            //即河流第stones[i]个格子是石头，是第 (i + 1) 个石头
        }

        return dfs(stones, 1, 1, len);

    }

    private boolean dfs (int[] stones, int cur, int dis, int len) {
        if (cur == len - 1) {
            return true;
        }
        //到达最后一个石头
        String key = cur + "_" + dis;
        //第 (cur + 1) 个石头，是跳 dis 步来的
        if (res.containsKey(key)) {
            return res.get(key);
        }

        for (int i = -1; i <= 1; i++) {
            //跳 （dis + i） 步
            if (dis + i == 0) {
                //一开始出发时可以选择 （1 + i） 0， 1， 2 步，0步在原地需要跳过
                continue;
            }

            int next = stones[cur] + i + dis;
            //河流第stones[next]个格子
            if (map.containsKey(next)) {
                //当这格子是石头，继续递归，得到这格子是第 （几 + 1）个格子
                boolean dfs = dfs(stones, map.get(next), i + dis, len);
                res.put(key, dfs);
                if (dfs) {
                    return true;
                }
            }
        }

        res.put(key, false);
        return false;


    }



    public boolean canCross(int[] stones) {
        /*
            当石头编号为 i 时，上一次跳的距离最大为 k ，因为石头编号从 0 开始，假设石头都存在
            0-----0
                    1-----1
							2-----1
								    3-----1
										    4-----1
									4-----2
						    3-----2
									4-----1
            如上，假设长度为5，则编号最大为4，每次跳跃的距离小于等于石头所在编号k <= i
            而算法是从后往前计算，则上一个编号 j ，他所跳跃的距离超过了 j + 1，则停止跳跃,
            即 k <= j + 1

            所以当 i 与 j 的距离超过 i ，则无法到达终点
         */
        if (stones[1] != 1) {
            return false;
        }
        int len = stones.length;
        for (int i = 1; i < len; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        boolean[][] dp = new boolean[len][len];

        dp[1][1] = true;
        //由开始的返回条件知为true

        for (int i = 2; i < len; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];

                if (k > j + 1) {
                    continue;
                }
                //即 k <= j + 1才可以进行计算
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
            }
        }
        /*
            在最后的石头遍历，已经跳跃距离 k <= i
            此时 i = len - 1，则 k <= len - 1
            而等于0怎样都不可能
         */
        for (int k = 1; k <= len - 1; k++) {
            if (dp[len - 1][k]) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        青蛙过河 cross = new 青蛙过河();
        int[] s = {0,1,3,5,6,8,12,17};
        System.out.println(cross.canCrossDfs(s));

    }

}
