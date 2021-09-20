package 剑指offer;

/**
 * Title: 零到n减一中缺少的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 零到n减一中缺少的数字 {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            res ^= (nums[i] ^ i);
        }
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        零到n减一中缺少的数字 res = new 零到n减一中缺少的数字();
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println(res.missingNumber(nums));
    }
}
