package labuladong;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: labuladong.Permute
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-10-26
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        permute.permute(nums);
        System.out.println(permute.res);
    }

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
