package 每日一题;

/**
 * Title: 解码异或后的数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-06
 */
public class 解码异或后的数组 {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length + 1;
        int[] res = new int[len];
        res[0] = first;
        for (int i = 1; i < len; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }
}
