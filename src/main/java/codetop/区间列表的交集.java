package codetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Title: 区间列表的交集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int inx1 = 0;
        int inx2 = 0;
        List<int[]> res = new ArrayList<>();
        int a0;
        int a1;
        int b0;
        int b1;
        while (inx1 < A.length && inx2 < B.length) {
            a0 = A[inx1][0];
            a1 = A[inx1][1];

            b0 = B[inx2][0];
            b1 = B[inx2][1];

            if (b1 >= a0 && a1 >= b0) {
                res.add(new int[]{Math.max(a0, b0), Math.min(a1, b1)});
            }

            if (b1 < a1) {
                inx2++;
            } else {
                inx1++;
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
