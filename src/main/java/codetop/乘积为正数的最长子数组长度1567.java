package codetop;

/**
 * Title: 乘积为正数的最长子数组长度1567
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-05
 */
public class 乘积为正数的最长子数组长度1567 {


    public static void main(String[] args) {
        乘积为正数的最长子数组长度1567 res = new 乘积为正数的最长子数组长度1567();
        System.out.println(res.getMaxLen(new int[]{1, -2, -3, 4}) + "\t4");
        System.out.println(res.getMaxLen(new int[]{-1,-2,-3,0,1}) + "\t2");
        System.out.println(res.getMaxLen(new int[]{0,1,-2,-3,-4}) + "\t3");
        System.out.println(res.getMaxLen(new int[]{-1,2}) + "\t1");
        System.out.println(res.getMaxLen(new int[]{1,2,3,5,-6,4,0,10}) + "\t4");
        System.out.println(res.getMaxLen(new int[]{-16,0,-5,2,2,-13,11,8}) + "\t6");
    }

//    public int getMaxLen(int[] nums) {
//        int len = nums.length;
//
//        int[] pos = new int[len];
//        int[] neg = new int[len];
//
//        if (nums[0] > 0) {
//            pos[0] = 1;
//        } else if (nums[0] < 0) {
//            neg[0] = 1;
//        }
//        int res = pos[0];
//        for (int i = 1; i < len; i++) {
//            if (nums[i] > 0) {
//                pos[i] = pos[i - 1] + 1;
//                /*
//                    + + +  2+1=3
//                    + - +  0+1=1
//                    + 0 +  0+1=1
//                    - 0 +  0+1=1
//                 */
//                neg[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
//                /*
//                    + + +  0+0=0
//                    + - +  2+1=3
//                    + 0 +  0+0=0
//                    - 0 +  0+0=0
//                 */
//            } else if (nums[i] < 0) {
//                pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
//                /*
//                    + + -   0+0=0
//                    + - -   1+1=0
//                    + 0 -   0+0=0
//                    - 0 -   0+0=0
//                 */
//                neg[i] = pos[i - 1] + 1;
//                /*
//                    + + -   2+1=3
//                    + - -   0+1=1
//                    + 0 -   0+1=1
//                    - 0 -   0+1=1
//                 */
//            } else {
//                pos[i] = 0;
//                neg[i] = 0;
//            }
//            res = Math.max(res, pos[i]);
//        }
//        return res;
//    }

    public int getMaxLen(int[] nums) {
        int len = nums.length;

        int pos = 0;
        int neg = 0;

        if (nums[0] > 0) {
            pos = 1;
        } else if (nums[0] < 0) {
            neg = 1;
        }
        int res = pos;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                pos = pos + 1;
                /*
                    + + +  2+1=3
                    + - +  0+1=1
                    + 0 +  0+1=1
                    - 0 +  0+1=1
                 */
                neg = neg > 0 ? neg + 1 : 0;
                /*
                    + + +  0+0=0
                    + - +  2+1=3
                    + 0 +  0+0=0
                    - 0 +  0+0=0
                 */
            } else if (nums[i] < 0) {
                int tmp = pos;
                pos = neg > 0 ? neg + 1 : 0;
                /*
                    + + -   0+0=0
                    + - -   1+1=0
                    + 0 -   0+0=0
                    - 0 -   0+0=0
                 */
                neg = tmp + 1;
                /*
                    + + -   2+1=3
                    + - -   0+1=1
                    + 0 -   0+1=1
                    - 0 -   0+1=1
                 */
            } else {
                pos = 0;
                neg = 0;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}
