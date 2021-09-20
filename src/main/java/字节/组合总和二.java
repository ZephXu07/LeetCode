package 字节;

import java.util.*;

/**
 * Title: 组合总和二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-25
 */
public class 组合总和二 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(track, candidates, 0, target);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.addLast(candidates[i]);
            backtrack(track, candidates, i + 1, target - candidates[i]);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        组合总和二 res = new 组合总和二();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = res.combinationSum2(candidates, target);
        for (List<Integer> l: lists) {
            for (int i: l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
