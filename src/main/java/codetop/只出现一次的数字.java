package codetop;

/**
 * Title: 只出现一次的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-27
 */
public class 只出现一次的数字 {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        /*
            全部异或，因为只有两个数单独出现一次
            n0 ^ n0 ^ n1 ^ n1 ^ n3 ^ n4
            = (n0 ^ n0) ^ (n1 ^ n1) ^ n3 ^ n4
            = 0 ^ 0 ^ n3 ^ n4
            = n3 ^ n4
            = res
            从最低位到最高位找到 res 第一个出现的 1
            表明 n3 ^ n4 在此位上不同
            再遍历一次，把此位上为 1 的一组异或，为 0 的另外一组异或
            因此 n3 ^ n4 被分开了
            而且 n0, n1 无论此位上是 0 是 1 ，在两组异或中都会为 0
            因为都出现两次，对同一个位进行 0 与 1的选择，两个相同的数会在同一组
            所以 n0^n0^n3 与 n1^n1^n4
            还是 n0^n0^n4 与 n1^n1^n3
            或是 n0^n0^n1^n1^n3 与 n4
            最后 n0^n0^n1^n1^n4 与 n3
            两组异或的值都会是 n3,n4
         */
        int inx = 1;
        while ((inx & res) == 0) {
            inx <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((n & inx) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};

    }
}
