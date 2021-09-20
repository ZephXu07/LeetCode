package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 组合
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-17
 */
public class 组合 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> track){
        if (0 == k) {
            res.add(new ArrayList(track));
            return ;
        }
        for (int i = start; i <= n - k + 1; i++) {
            /*
                设当前位的选择有 x 种，还剩下 (k-1)个位没有补充
                还剩下可以选的数字有 n 种，最后有 x + (k-1) = n
                即 x = n - k + 1
             */
            track.add(i);
            backtrack(n, k - 1, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
