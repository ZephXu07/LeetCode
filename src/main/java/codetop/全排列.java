package codetop;

import java.util.*;

/**
 * Title: 全排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-02
 */
public class 全排列 {
    private List<List<Integer>> res;
    private boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0, ans);
        return res;
    }

    private void helper (int[] nums, int len, LinkedList<Integer> ans) {
        /*
            排序，使相同的相邻，如果有上一个且上一个等于现在这个，且如果他没有被使用了
            则说明此排列已经有了，再使用就是重复
         */
        if (len == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] ||
                    (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                /*
                     1 1 2
                    一个 ||
                    如果前面没有过，直接 true 可以下一步  第 2 个 1 的第一次使用 1 1 2
                    如果前面有过了，看是否相同及使用
                    1    2
                    1 2 1

                    2    1
                    1 2 1

                    此处两个 1 可能不同，但由于此处的判断，只会选择
                    1   2
                    1 2 1

                    因为发现前面的第一个 1 没被使用，取消使用此排列


                 */
                continue;
            }
            ans.add(nums[i]);
            visited[i] = true;
            helper(nums, len + 1, ans);
            ans.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        全排列 res = new 全排列();
        res.permuteUnique(new int[]{1,1,2});
    }

}
