package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 汇总区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (null == nums || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = 0;
        int cur = 1;
        int end = 0;
        while (cur < nums.length) {
            if (nums[cur] != nums[end] + 1) {
               if (start != end) {
                   res.add(nums[start] + "->" + nums[end]);
               } else {
                   String tmp = String.valueOf(nums[start]);
                   res.add(tmp);
               }
               start = cur;
           }
            end = cur;
            cur++;
            if (cur == nums.length) {
                if (start != end) {
                    res.add(nums[start] + "->" + nums[end]);
                } else {
                    String tmp = String.valueOf(nums[start]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        汇总区间 res = new 汇总区间();
//        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
        int[] nums = {-1,1};
        res.summaryRanges(nums).forEach(System.out::println);
    }
}
