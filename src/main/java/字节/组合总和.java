package 字节;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 组合总和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-23
 */
public class 组合总和 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        while (start < candidates.length) {
            int tmp = target - candidates[start];
            if (tmp < 0) {
                break;
            }
//            System.out.println("递归前" + track);
            track.addLast(candidates[start]);
            backtrack(track, candidates, start, tmp);
            track.removeLast();
//            System.out.println("递归后" + track);
            start++;
        }
    }

    public static void main(String[] args) {
        组合总和 res = new 组合总和();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = res.combinationSum(candidates, target);
        System.out.println("结果" + lists);
    }
}
