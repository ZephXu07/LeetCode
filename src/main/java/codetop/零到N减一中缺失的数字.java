package codetop;

/**
 * Title: 零到N减一中缺失的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 零到N减一中缺失的数字 {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0? 1 : 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        零到N减一中缺失的数字 res = new 零到N减一中缺失的数字();
        System.out.println(res.missingNumber(new int[]{0, 1, 3}) + "\t2");
        System.out.println(res.missingNumber(new int[]{0,1,2,3,4,5,6,7,9})+ "\t8");
        System.out.println(res.missingNumber(new int[]{0})+ "\t1");
        System.out.println(res.missingNumber(new int[]{1})+ "\t0");
        System.out.println(res.missingNumber(new int[]{0,2})+ "\t1");
    }
}
