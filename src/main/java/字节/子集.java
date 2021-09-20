package 字节;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class 子集 {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
