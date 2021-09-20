package 每日一题;

/**
 * Title: 只出现一次的数字二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-30
 */
public class 只出现一次的数字二 {
    public int singleNumber(int[] nums) {
        /*
            0 -- 0 --> 0
            0 -- 1 --> 1
            1 -- 0 --> 1
            1 -- 1 --> 2
            2 -- 0 --> 2
            2 -- 1 --> 0

            ba           ba
            00 --> 0 --> 00
            00 --> 1 --> 01
            01 --> 0 --> 01
            01 --> 1 --> 10
            10 --> 0 --> 10
            10 --> 1 --> 00

            先计算 新a
            a = (a ^ n) & ~b
            再根据 新a 计算 新b
            b = (b ^ n) & ~b

            遍历完所有数字后，各二进制位都处于状态 0000 和状态 0101 ，
            因为出现三次的重置为0，即00，出现一次的为01，所以只需要 ba 位置的 a

            计算过程中32个位都会进行计算，再遍历数组所有值，最终剩下的就是出现一次

         */




        int a = 0, b = 0;
        for(int num : nums){
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }
}
