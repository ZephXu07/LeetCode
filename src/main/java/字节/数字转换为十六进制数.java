package 字节;

import java.util.Arrays;

/**
 * Title: 数字转换为十六进制数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 数字转换为十六进制数 {
    private static final char[] chars = {'0', '1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if (num > 0) {
            return getHex(num);
        } else if (num == 0) {
            return "0";
        } else {
            int[] bits = new int[32];
            int[] val = new int[8];
            for (int i = 0; i < 32; i++) {
                bits[i] = (num & 0x80000000 >>> i) >>> (31 - i);
                val[i / 4] = val[i / 4] * 10 + bits[i];
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                int tmp = 0;
                for (int i = 0; i < 4; i++) {
                    tmp = tmp + (int)Math.pow(2, i) * val[j] % 10;
                    val[j] /= 10;
                }
                val[j] = tmp;
            }
            for (int i : val) {
                builder.append(getHex(i));
            }
            return builder.toString();
        }

    }

    private String getHex(int num) {
        if (num == 0) {
            return "0";
        }
        int tmp = num;
        StringBuilder builder = new StringBuilder();
        while (tmp != 0) {
            int inx = tmp % 16;
            tmp /= 16;
            builder.append(chars[inx]);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        数字转换为十六进制数 res = new 数字转换为十六进制数();
        int num = -100000;
        System.out.println(res.toHex(num));
    }
}
