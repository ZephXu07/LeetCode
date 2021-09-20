package codetop;

import 程序员代码面试指南.栈和队列.设计一个有getMin功能的栈;

/**
 * Title: 找到需要补充粉笔的学生编号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-10
 */
public class 找到需要补充粉笔的学生编号 {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long[] pre = new long[len];
        pre[0] = chalk[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + chalk[i];
        }
        int target = (int) ( k % pre[len - 1]);

        int left = 0;
        int right = len - 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (pre[mid] <= target) {
                left = mid + 1;
            } else if (pre[mid] > target){
                right = mid;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        找到需要补充粉笔的学生编号 res = new 找到需要补充粉笔的学生编号();
        System.out.println(res.chalkReplacer(new int[]{5, 1, 5}, 22) + "\t0");
        System.out.println(res.chalkReplacer(new int[]{3,4,1,2}, 25) + "\t1");
    }
}
