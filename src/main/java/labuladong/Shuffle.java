package labuladong;

import java.util.Arrays;
import java.util.Random;

/**
 * Title: labuladong.Shuffle
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-15
 */
public class Shuffle {
    private int[] nums;
    private int[] origin;
    public Shuffle(int[] nums) {
        this.nums = nums;
        this.origin = nums.clone();
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int length = nums.length;
        Random r = new Random();
        int random;
        for (int i = 0; i < length - 1; i++) {
            random = r.nextInt(length - i) + i;
            swap(i, random);
        }
        return nums;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(Arrays.stream(shuffle.shuffle()).toArray()));
        System.out.println("-------------");
        System.out.println(Arrays.toString(Arrays.stream(shuffle.reset()).toArray()));
        System.out.println(shuffle.nums.hashCode() == shuffle.origin.hashCode());
    }
}
