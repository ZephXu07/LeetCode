package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: labuladong.SuperEggDrop
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-28
 */
public class SuperEggDrop {
    private Map<String, Integer> memo = new HashMap<>();
    public int superEggDrop(int K, int N) {
        if (1 == K) {
            return N;
        }
        if (0 == N) {
            return 0;
        }
        if (memo.containsKey(K + "/" + N)) {
            return memo.get(K + "/" + N);
        }
        int res = Integer.MAX_VALUE;
        int low = 1;
        int high = N;
        int mid;
        int broken;
        int notBroken;
        while (low <= high) {
            mid = low + (high - low) / 2;
            broken = superEggDrop(K - 1, mid - 1);
            notBroken = superEggDrop(K, N - mid);
            if (broken > notBroken) {
                high = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                low = mid + 1;
                res = Math.min(res, notBroken + 1);
            }
        }
        memo.put(K + "/" + N, res);
        return res;
    }



    public static void main(String[] args) {
        SuperEggDrop res = new SuperEggDrop();
        System.out.println(res.superEggDrop(2, 6));
    }
}
