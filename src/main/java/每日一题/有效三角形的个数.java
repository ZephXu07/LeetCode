package 每日一题;

import java.util.Arrays;

/**
 * Title: 有效三角形的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-04
 */
public class 有效三角形的个数 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        /*
            a+b>c
            a+c>b
            b+c>a

            排序之后 a < b < c
            只需要保证 a+b>c
            即 nums[a] + nums[b] = target，找到小于 target 的最大值，而其下标减去 b 的下标的范围则是 c 的个数
         */
        for (int a = 0; a < len; a++) {
            for (int b = a + 1; b < len; b++) {
                int left = b + 1;
                int right = len - 1;
                int target = nums[a] + nums[b];
                int k = b;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < target) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                res += k - b;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        有效三角形的个数 res = new 有效三角形的个数();
        System.out.println(res.triangleNumber(new int[]{2, 2, 3, 4}) + "\t3");
        System.out.println(res.triangleNumber(new int[]{4, 2, 3, 4}) + "\t4");
        System.out.println(res.triangleNumber(new int[]{1, 1, 3, 4}) + "\t0");
    }
}
