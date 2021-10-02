package 每日一题;

/**
 * Title: 数字转换为十六进制数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 数字转换为十六进制数 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (i * 4)) & 15;
            /*
                32 位 -> 4 位 * 8
                4 位一个 16 进制数
                num >> (i * 4) 是哪个组的
                & 15 得到值
             */
            if (res.length() > 0 || val != 0) {
                char c = (char) (val > 9 ? val - 10 + 'a' : val + '0');
                res.append(c);
            }
        }
        return res.toString();
    }
}
