package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 祖玛游戏488
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-09
 */
public class 祖玛游戏488 {
    private int res = Integer.MAX_VALUE;

    private Map<Character, Integer> map = new HashMap<>();
    {
        map.put('R', 0);
        map.put('Y', 0);
        map.put('B', 0);
        map.put('G', 0);
        map.put('W', 0);
    }

    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    public int findMinStep(String board, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            char c = hand.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        dfs(new StringBuilder(board), 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(StringBuilder board, int step) {
        if (step >= res) {
            /*
                超过则停止
             */
            return;
        }
        if (board.length() == 0) {
            res = step;
            /*
                因为前面超过就停止了，于是不使用比较函数
             */
            return;
        }
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int j = i;
            while (j + 1 < board.length() && board.charAt(j + 1) == c) {
                j++;
            }
            if (j == i && map.get(c) >= 2) {
                /*
                    只有单个球
                    且有多余2个的同颜色的球
                 */
                StringBuilder tmp = new StringBuilder(board);
                tmp.insert(i, c + "" + c);
                map.put(c, map.get(c) - 2);
                dfs(update(tmp), step + 2);
                map.put(c, map.get(c) + 2);
            } else if (j == i + 1) {
                /*
                    存在两个颜色相同且相邻的球
                 */
                if (map.get(c) >= 1) {
                    /*
                        有多余的1个的同颜色的球，与上面的单个球同样做法
                     */
                    StringBuilder tmp = new StringBuilder(board);
                    tmp.insert(i, c);
                    map.put(c, map.get(c) - 1);
                    dfs(update(tmp), step + 1);
                    map.put(c, map.get(c) + 1);
                }
                for (char color : colors) {
                    if (color == c) {
                        continue;
                    }
                    if (map.get(color) >= 1) {
                        StringBuilder tmp = new StringBuilder(board);
                        tmp.insert(i + 1, color);
                        /*
                            尝试往这两个颜色相同且相邻的球中间插入一个颜色不同的球
                         */
                        map.put(color, map.get(color) - 1);
                        dfs(update(tmp), step + 1);
                        map.put(color, map.get(color) + 1);
                    }
                }
            }
        }
    }

    private StringBuilder update(StringBuilder str) {
        /*
            更新插入新字符之后可能要消除的情况
         */
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < str.length(); i++) {
                int j = i + 1;
                while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    /*
                        寻找到三个及以上相同的，
                        消除，再尝试寻找更新
                     */
                    str.delete(i, j);
                    flag = true;
                }
            }
        }
        return str;
    }

}
