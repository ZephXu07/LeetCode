package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 没有重复元素集合的全排列083
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 没有重复元素集合的全排列083 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
