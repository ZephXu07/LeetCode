package weekTwo62;

/**
 * Title: 连接后等于目标字符串的字符串对5872
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 连接后等于目标字符串的字符串对5872 {

    public int numOfPairs(String[] nums, String target) {

        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]).equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        连接后等于目标字符串的字符串对5872 res = new 连接后等于目标字符串的字符串对5872();
        String[] nums = {"777","7","77","77"};
        String target = "7777";
        System.out.println(res.numOfPairs(nums, target));
    }
}
