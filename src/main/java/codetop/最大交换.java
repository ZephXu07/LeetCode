package codetop;

import java.util.*;

/**
 * Title: 最大交换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 最大交换 {
//    public int maximumSwap(int num) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>(9, (i1,i2)->i2-i1);
//        int tmp = num;
//        int[] arr = new int[9];
//        int inx = 8;
//        while (tmp != 0) {
//            int n = tmp % 10;
//            heap.offer(n);
//            tmp /= 10;
//            arr[inx--] = n;
//        }
//        inx++;
//        int res = 0;
//        while (inx < 9 && arr[inx] == heap.peek()) {
//            res = res * 10 + heap.poll();
//            inx++;
//        }
//        if (inx < 9) {
//            tmp = arr[inx++];
//            res = res * 10 + heap.peek();
//            res *= Math.pow(10, 8 - inx + 1);
//            boolean flag = true;
//            int len = 8;
//            int ans = 0;
//            int mul = 1;
//            while (len >= inx) {
//                if (arr[len] == heap.peek() && flag) {
//                    arr[len] = tmp;
//                    flag = false;
//                }
//                ans += arr[len] * mul;
//                mul *= 10;
//                len--;
//            }
//            res += ans;
//        }
//        return res;
//    }

    public int maximumSwap(int num) {
        /*
        nums
            0 1 2 3
            1 9 9 3
        maxArr
            0 1 2 3
            2 2 2 3
            意思是 0 上的值与其右边往左最大的值的下标（最大值多个取最右）相比，
            不等则 0 与 2 交换值，则是题目要求
        nums
            0 1 2 3 4
            9 8 3 6 8
        maxArr
            0 1 2 3 4
            0 4 4 4 4
         0 1 相等，不变
         2 不等，交换 2 与 4

         */
        char[] nums = Integer.toString(num).toCharArray();
        /*
            数字每个位上原本的值
         */
        int maxInx = nums.length - 1;
        int[] maxArr = new int[nums.length];
        /*
            从右往左遍历，寻找其右边比此位大的值的下标，如果从右往左有相等的，则取右边的
         */

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[maxInx]) {
                maxInx = i;
            }
            maxArr[i] = maxInx;
        }
        /*
            从左往右遍历，如果此位上的值不是其右往左的最大值，则进行交换，直接结束，因为只能交换一次
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxArr[i]] != nums[i]) {
                char tmp = nums[maxArr[i]];
                nums[maxArr[i]] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }

    public static void main(String[] args) {
        最大交换 res = new 最大交换();
        System.out.println(res.maximumSwap(2736) + "\t 7236");
        System.out.println(res.maximumSwap(9973) + "\t 9973");
        System.out.println(res.maximumSwap(12) + "\t 21");
        System.out.println(res.maximumSwap(98368) + "\t 98863");
        System.out.println(res.maximumSwap(1993) + "\t 9913");
    }
}
