package 字节;

/**
 * Title: 多数元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-04
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        Integer res = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            res = count == 0 ? nums[i] : res;
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        多数元素 res = new 多数元素();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(res.majorityElement(nums));
    }
}
