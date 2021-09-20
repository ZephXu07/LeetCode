package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: labuladong.IsRectangleCover
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-27
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int[] i : rectangles) {
            area += (i[2] - i[0]) * (i[3] - i[1]);
            x1 = Math.min(i[0], x1);
            y1 = Math.min(i[1], y1);
            x2 = Math.max(i[2], x2);
            y2 = Math.max(i[3], y2);
            String[] m = {i[0] + " ,"+ i[1],
            i[0] + " ,"+ i[3],
            i[2] + " ,"+ i[3],
            i[2] + " ,"+ i[1]};
            for (int j = 0; j < m.length; j++) {
                if (memo.containsKey(m[j])) {
                    memo.remove(m[j]);
                } else {
                    memo.put(m[j], 1);
                }
            }

        }
        int rectangle = (y2 - y1) * (x2 - x1);
        if (area != rectangle) {
            return false;
        }
        if (memo.size() != 4) {
            return false;
        }
        if (!memo.containsKey(x1 + " ," + y1)) {
            return false;
        }
        if (!memo.containsKey(x1 + " ," + y2)) {
            return false;
        }
        if (!memo.containsKey(x2 + " ," + y1)) {
            return false;
        }
        return memo.containsKey(x2 + " ," + y2);

    }

    public static void main(String[] args) {
        int[][] rectangles = {{1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        IsRectangleCover res = new IsRectangleCover();
        boolean b = res.isRectangleCover(rectangles);
        System.out.println(b);

    }
}
