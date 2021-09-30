package 剑指offer专项突击版;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 允许重复选择元素的组合081
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 允许重复选择元素的组合081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, target, 0, 0, res, track);
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
            track.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i,
                    res, track);
            track.removeLast();
        }
    }
}
