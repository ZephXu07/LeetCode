package codetop;

import java.util.Arrays;

/**
 * Title: 最少交换次数来组合所有的1
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-17
 */
public class 最少交换次数来组合所有的1 {
    public int minSwaps (int[] data) {
        /*
            把所有 1 聚在一起
            相当于一个窗口内都是 1
            所以先统计 1 的个数
            因为是二进制只有 1 与 0
            所以数组的和就是 1 的个数 size
            所以窗口大小 size

            滑动窗口解，size - 窗口的值的差的最小值
            即是最小交换次数
         */
        int len = data.length;
        int size = Arrays.stream(data).sum();

        int win = 0;
        int res = size;
        for (int i = 0; i < size; i++) {
            /*
                先添加 size 个数
             */
            win += data[i];
        }

        for (int i = size; i < len; i++) {
            res = Math.min(res, size - win);
            /*
                比较
             */

            win += data[i];
            /*
                右边增加，
                因为只有 0 与 1
                0 无影响
                1 是需要的
             */

            win -= data[i - size];
            /*
                左边缩减
                同理
             */


        }

        return res;
        /*
            或者使用前缀和，统计
            pre[i] - pre[i-size] 的差的最小值
         */

    }

    public static void main(String[] args) {
        最少交换次数来组合所有的1 res = new 最少交换次数来组合所有的1();
        System.out.println(res.minSwaps(new int[]{1, 0, 1, 0, 1}) + "\t1");
        System.out.println(res.minSwaps(new int[]{0,0,0,1,0}) + "\t0");
        System.out.println(res.minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}) + "\t3");
    }
}
