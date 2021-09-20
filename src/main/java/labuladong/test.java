package labuladong;

/**
 * Title: labuladong.test
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-06
 */
public class test {

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate(nums, 2);
    }

    public static void rotate(int[] nums, int k) {
        for (int s:nums) {
            System.out.print(s + "\t\t");
        }
        if (k % nums.length == 0) {
            return;
        }
        if (k >= nums.length) {
            k = k % nums.length;
        }
        int temp = nums[0];
        int value = nums[0];
        int index = 0;
        int start = index + k;
        for (int i = 0; i < nums.length; i++) {
            temp = value;
            if((index + k) % nums.length == start) {
                index ++;
                start = (index + k) % nums.length;
                value = nums[index];
            } else {
                index = (index + k) % nums.length;
            }
            value = nums[index];
            nums[index] = temp;
        }
        System.out.println();
        for (int s:nums) {
            System.out.print(s+ "\t\t");
        }
    }
}
