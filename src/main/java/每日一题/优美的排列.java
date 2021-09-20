package 每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: 优美的排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-16
 */
public class 优美的排列 {
//    private int res;
//    private int n;
//    public int countArrangement(int n) {
//        this.n = n;
//        Set<Integer> set = new HashSet<>();
//        dfs(1, set);
//        return res;
//    }
//
//    private void dfs (int inx, Set<Integer> set) {
//        if (inx > n) {
//            res++;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (set.contains(i)) {
//                continue;
//            }
//            if (i % inx == 0 || inx % i == 0) {
//                set.add(i);
//                dfs(inx + 1, set);
//                set.remove(i);
//            }
//        }
//    }

    private int res;
    private int n;
    private List<Integer>[] match;
    public int countArrangement(int n) {
        this.n = n;
        boolean[] visited = new boolean[n + 1];
        match = new List[n + 1];
        match[0] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            match[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        dfs(1, visited);
        return res;
    }

    private void dfs (int inx, boolean[] visited) {
        if (inx > n) {
            res++;
            return;
        }
        for (int i : match[inx]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(inx + 1, visited);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        优美的排列 res = new 优美的排列();
        System.out.println(res.countArrangement(1));
        res = new 优美的排列();
        System.out.println(res.countArrangement(2));
        res = new 优美的排列();
        System.out.println(res.countArrangement(3));
        res = new 优美的排列();
        System.out.println(res.countArrangement(4));
        res = new 优美的排列();
        System.out.println(res.countArrangement(5));
        res = new 优美的排列();
        System.out.println(res.countArrangement(6));
        res = new 优美的排列();
        System.out.println(res.countArrangement(7));
        res = new 优美的排列();
        System.out.println(res.countArrangement(8));
        res = new 优美的排列();
        System.out.println(res.countArrangement(9));
        res = new 优美的排列();
        System.out.println(res.countArrangement(10));
        res = new 优美的排列();
        System.out.println(res.countArrangement(11));

        res = new 优美的排列();
        System.out.println(res.countArrangement(12));
        res = new 优美的排列();
        System.out.println(res.countArrangement(13));
        res = new 优美的排列();
        System.out.println(res.countArrangement(14));
        res = new 优美的排列();
        System.out.println(res.countArrangement(15));
    }
}
