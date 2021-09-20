package 每日一题;

import java.util.*;

/**
 * Title: 滑动谜题
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-26
 */
public class 滑动谜题 {
    private List<int[]> to;
    public 滑动谜题 () {
        to = new ArrayList<>();
        to.add(new int[]{1,3});
        to.add(new int[]{0,2,4});
        to.add(new int[]{1,5});
        to.add(new int[]{0,4});
        to.add(new int[]{1,3,5});
        to.add(new int[]{2,4});
    }
    public int slidingPuzzle(int[][] board) {
        String start;
        String target = "123450";
        int zero = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero = i * 3 + j;
                }
                builder.append(board[i][j]);
            }
        }
        start = builder.toString();
        if (start.equals(target)) {
            return 0;
        }

        Map<String, Integer> s1 = new HashMap<>();
        s1.put(start, zero);
        Map<String, Integer> s2 = new HashMap<>();
        s2.put(target, 5);
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Map<String, Integer>  tmp = new HashMap<>();

            for (Map.Entry<String, Integer> entry : s1.entrySet()) {
                String key = entry.getKey();
                int val = entry.getValue();
                if (visited.contains(key)) {
                    continue;
                }
                if (s2.containsKey(key)) {
                    return step;
                }
                visited.add(key);

                Map<String, Integer> next = nextString(key, val, to.get(val));
                for (Map.Entry<String, Integer> e : next.entrySet()) {
                    if (visited.contains(e.getKey())) {
                        continue;
                    }
                    tmp.put(e.getKey(), e.getValue());
                }
            }

            step++;
            if (s2.size() <= tmp.size()) {
                s1 = s2;
                s2 = tmp;
            } else {
                s1 = tmp;
            }
        }
        return -1;
    }

    private Map<String, Integer> nextString (String old, int cur, int[] to) {
        Map<String, Integer> res = new HashMap<>();
        for (int i : to) {
            StringBuilder newStr = new StringBuilder(old);
            newStr.setCharAt(i, '0');
            newStr.setCharAt(cur, old.charAt(i));
            res.put(newStr.toString(), i);
        }
        return res;
    }

    public static void main(String[] args) {
        滑动谜题 res = new 滑动谜题();
        int[][] board = {{1,2,3},{4,0,5}};
        System.out.println(res.slidingPuzzle(board));
    }
}
