package 每日一题;

/**
 * Title: 主要元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-09
 */
public class 主要元素 {
    public int majorityElement(int[] nums) {
        /*
            预选 res =  nums[0] 为所求的数，次数 count 为1，进行遍历
            如果相同则次数增加，否则当次数大于等于 1 时则减 1 ，
            否则新的数设为预选的数，次数为 1 ，直到遍历完成
            此时 res 的值可能是众数，或者是前面偶数个数字互不相同，它是最后一个
            根据题干是要求出数量大于一半的，因此再次遍历数组，计算等于 res 的数有多少个，
            次数大于数组长度一半即为所求，否则则返回 -1
         */
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int res = nums[0];
        int count = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int n : nums) {
            if (n == res) {
                count++;
            }
        }
        return count > len / 2 ? res : -1;
    }

}
