package labuladong;

import java.util.Arrays;

/**
 * Title: labuladong.EatGrapes
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-22
 */
public class EatGrapes {
    public long eatGrapes(long a, long b, long c) {
        long[] nums = {a, b, c};
        Arrays.sort(nums);
        long sum = a + b + c;
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }
        if (2 * (nums[0] + nums[1]) > nums[2]) {
            return (nums[2] + 1) / 3;
        }
        return (sum + 2) / 3;
    }

    public static void main(String[] args) {

    }
}
