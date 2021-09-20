package 每日一题;


import java.util.*;

/**
 * Title: 子集二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-31
 */
public class 子集二 {
//    private List<List<Integer>> res;
//    private Set<String> memo;
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        res = new LinkedList<>();
//        memo = new HashSet<>();
//        LinkedList<Integer> ans = new LinkedList<>();
//        helper(ans, 0, nums);
//        return res;
//    }
//
//    private void helper (LinkedList<Integer> ans, int start, int[] nums) {
//        StringBuilder builder = new StringBuilder();
//        for (Integer i : ans) {
//            builder.append(i);
//        }
//        String s = builder.toString();
//        if (!memo.contains(s)) {
//            memo.add(s);
//            res.add(new LinkedList<>(ans));
//        }
//        for (int i = start; i < nums.length; i++) {
//            ans.add(nums[i]);
//            helper(ans, i + 1, nums);
//            ans.removeLast();
//        }
//    }


    private List<Integer> ans = new LinkedList<>();
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new LinkedList<>(ans));
            return;
        }
        ans.add(nums[cur]);
        dfs(true, cur + 1, nums);
        ans.remove(ans.size() - 1);
        //一路都选，所以choosePre为true


        if (choosePre && nums[cur - 1] == nums[cur]) {
            return;
        }
        //次数choosePre 为true，当前后相同即跳过}

        dfs(false, cur + 1, nums);
        //因为不同，所以选择
    }


    public static void main(String[] args) {
        子集二 res = new 子集二();
        int[] nums = {1,2,2};
        List<List<Integer>> lists = res.subsetsWithDup(nums);
        for (List<Integer> l : lists) {
            System.out.print("[");
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println("]\n");
        }
    }

}
