package 剑指offer专项突击版;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 含有重复元素集合的组合082
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 含有重复元素集合的组合082 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, target, 0,  0, res, track);
        return res;
    }


    private void backtrack (int[] candidates, int target, int sum, int inx,
                            List<List<Integer>> res, LinkedList<Integer> track) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = inx; i < candidates.length; i++) {
            if (i > inx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1, res, track);
            track.removeLast();
        }
    }
}
