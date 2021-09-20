package twotwosix周赛;

import java.util.*;

/**
 * Title: 从相邻元素对还原数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-31
 */
public class 从相邻元素对还原数组 {
    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        int[] res = new int[len + 1];
        //构建邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            int num1 = pair[0], num2 = pair[1];
            map.computeIfAbsent(num1, k -> new ArrayList<>()).add(num2);
            map.computeIfAbsent(num2, k -> new ArrayList<>()).add(num1);
        }
        //寻找一个起点
        for(int key : map.keySet()) {
            if(map.get(key).size() == 1) {
                //数组索引0
                res[0] = key;
                break;
            }
        }
        //数组索引[1, len]
        for (int i = 1; i <= len; i++) {
            //当res[i]值由上一个位置key对应的List决定
            List<Integer> list = map.get(res[i-1]);
            for (int num : list) {
                if (map.containsKey(num)) {
                    res[i] = num;
                    break;
                }
            }
            map.remove(res[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        从相邻元素对还原数组 res = new 从相邻元素对还原数组();
//        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        int[][] adjacentPairs = {{4,-2},{1,4},{-3,1}};
        System.out.println(Arrays.toString(res.restoreArray(adjacentPairs)));
    }
}
