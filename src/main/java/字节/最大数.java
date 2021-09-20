package 字节;

import java.util.*;

/**
 * Title: 最大数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-19
 */
public class 最大数 {

    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return String.valueOf(nums[0]);
        }
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (s1, s2)-> {
            String sum1 = s1 + s2;
            String sum2 = s2 + s1;
            return sum2.compareTo(sum1);
        });
        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
        }
        return "0".equals(str[0]) ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        最大数 res = new 最大数();
        int[] nums = {34,4};
        System.out.println(res.largestNumber(nums));
    }

}
