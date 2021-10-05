package 每日一题;

/**
 * Title: 第三大的数414
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 第三大的数414 {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        long one = Long.MIN_VALUE;
        long two = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            if (nums[i] > one) {
                three = two;
                two = one;
                one = nums[i];
            } else if (one > nums[i] && nums[i] > two) {
                three = two;
                two = nums[i];
            } else if (two > nums[i] && nums[i] > three) {
                three = nums[i];
            }
        }
        return three == Long.MIN_VALUE ? (int) one : (int) three;
    }

    public static void main(String[] args) {
        第三大的数414 res = new 第三大的数414();
        System.out.println(res.thirdMax(new int[]{3, 2, 1}));
        System.out.println(res.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
