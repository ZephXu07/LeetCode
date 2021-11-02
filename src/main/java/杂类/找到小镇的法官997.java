package 杂类;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 找到小镇的法官997
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-02
 */
public class 找到小镇的法官997 {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        for (int[] t : trust) {
            set.remove(t[0]);
            count[t[1]]++;
        }

        if (set.size() != 1) {
            return -1;
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                if (res != 0) {
                    return -1;
                }
                res = i;
            }
        }
        return res == 0 ? -1 : res;
    }
}
