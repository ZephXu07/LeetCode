package codetop;

import labuladong.Solution;

/**
 * Title: 求1到n的和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 求1到n的和 {
//    public int sumNums(int n) {
//        return n == 0 ? 0 : n + sumNums(n - 1);
//        /*
//            使用短路和递归
//         */
//    }

    public int sumNums(int n) {
        /*
            等差数列求和  n(n+1)/2
            将 B = (n+1) 二进制展开
            位上为 1 则乘以 A，加到结果上
            B 由于取最低位的 1 每次除以 2 右移 1 位
            所以 A 补充乘以 2 即左移 1 位
            因为数据大小为 1000
            约 14 位 所以展开 14 次
            最后再除以 2 右移 1 位
         */
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }
}
