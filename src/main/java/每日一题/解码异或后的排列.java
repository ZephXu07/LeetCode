package 每日一题;

/**
 * Title: 解码异或后的排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-11
 */
public class 解码异或后的排列 {
    public int[] decode(int[] encoded) {
        //由题知是 encoded.length + 1个数异或结果，直接求前n个数结果
        //再由异或结果挑下标为奇数可以求出除第一个数以外的结果
        //相异或得出第一个，不断异或则可以得到原数组
        int len = encoded.length;
        int sum = sumXor(len + 1);
        int sum1 = 0;
        for (int i = 0; i <= len; i++) {
//            sum ^= (i + 1);
            if ((i & 1) == 1) {
                sum1 ^= encoded[i];
            }
        }
        int first = sum ^ sum1;
        int[] res = new int[len + 1];
        res[0] = first;
        for (int i = 1; i <= len; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;

    }
    private int sumXor(int n) {
        if (n % 4 == 0) {
            return n;
        }
        if (n % 4 == 1) {
            return 1;
        }
        if (n % 4 == 2) {
            return n + 1;
        }
        return 0;
    }


}
