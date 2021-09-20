package labuladong;

/**
 * Title: labuladong.MissingNumber
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-18
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int ans = 0;
        ans ^= len;
        for (int i = 0; i < len; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 新补的索引
        res += n;
        // 剩下索引和元素的差加起来
        for (int i = 0; i < n; i++) {
            res += i - nums[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
