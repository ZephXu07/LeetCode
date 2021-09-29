package codetop;

/**
 * Title: 摆动序列376
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 摆动序列376 {
//    public int wiggleMaxLength(int[] nums) {
//        int len = nums.length;
//        if (0 == len || 1 == len) {
//            /*
//                0 自然长度 0
//                1 题目说明也算
//             */
//            return len;
//        }
//        if (2 == len) {
//            /*
//                两个数字则看是否相等，不等则有两个
//                否则只能取一个作为最长长度
//             */
//            return nums[1] - nums[0] == 0 ? 1 : 2;
//        }
//        int[] dp = new int[len];
//        /*
//            以 nums[i] 结尾的序列的最长摆动序列长度
//         */
//        dp[0] = 1;
//        int j = 1;
//        while (j < len && nums[j] - nums[j - 1] == 0) {
//            dp[j] = 1;
//            j++;
//            /*
//                过滤掉相等的，这些长度均为 1
//             */
//        }
//        boolean flag = true;
//        if (j < len) {
//            dp[j] = 2;
//            flag = nums[j] - nums[j - 1] > 0;
//            /*
//                确定初始方向
//             */
//        }
//        for (int i = j + 1; i < len; i++) {
//            /*
//                根据方向进行判断
//             */
//            if (flag) {
//                if (nums[i] - nums[i - 1] >= 0) {
//                    dp[i] = dp[i - 1];
//                } else {
//                    dp[i] = Math.max(dp[i - 1], dp[i - 1] + 1);
//                    flag = false;
//                }
//            } else {
//                if (nums[i] - nums[i - 1] > 0) {
//                    dp[i] = Math.max(dp[i - 1], dp[i - 1] + 1);
//                    flag = true;
//                } else {
//                    dp[i] = dp[i - 1];
//                }
//            }
//        }
//        return dp[len - 1];
//    }

//    public int wiggleMaxLength(int[] nums) {
//        int len = nums.length;
//        if (0 == len || 1 == len) {
//            /*
//                0 自然长度 0
//                1 题目说明也算
//             */
//            return len;
//        }
//        if (2 == len) {
//            /*
//                两个数字则看是否相等，不等则有两个
//                否则只能取一个作为最长长度
//             */
//            return nums[1] - nums[0] == 0 ? 1 : 2;
//        }
//        int[] dp = new int[2];
//        /*
//            以 nums[i] 结尾的连续序列的最长摆动序列长度
//         */
//        dp[0] = 1;
//        int j = 1;
//        while (j < len && nums[j] - nums[j - 1] == 0) {
//            dp[j] = 1;
//            j++;
//            /*
//                过滤掉相等的，这些长度均为 1
//             */
//        }
//        boolean flag = true;
//        if (j < len) {
//            dp[j % 2] = 2;
//            flag = nums[j] - nums[j - 1] > 0;
//            /*
//                确定初始方向
//             */
//        }
//        for (int i = j + 1; i < len; i++) {
//            /*
//                根据方向进行判断
//             */
//            if (flag) {
//                if (nums[i] - nums[i - 1] >= 0) {
//                    dp[i % 2] = dp[(i - 1) % 2];
//                } else {
//                    dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 1) % 2] + 1);
//                    flag = false;
//                }
//            } else {
//                if (nums[i] - nums[i - 1] > 0) {
//                    dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 1) % 2] + 1);
//                    flag = true;
//                } else {
//                    dp[i % 2] = dp[(i - 1) % 2];
//                }
//            }
//        }
//        return dp[(len - 1) % 2];
//    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int pre = nums[1] - nums[0];
        int res = pre == 0 ? 1 : 2;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff < 0 && pre >= 0)
                    || (diff > 0 && pre <= 0)) {
                res++;
                pre = diff;
            }
        }
        return res;
    }
}
