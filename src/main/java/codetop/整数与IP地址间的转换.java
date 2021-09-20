package codetop;

import java.util.Scanner;

/**
 * Title: 整数与IP地址间的转换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-20
 */
public class 整数与IP地址间的转换 {
    public long ipToInt (String ip) {
        String[] ips = ip.split("\\.");
        long res = 0;
        for (String s : ips) {
            res = res << 8 | Integer.parseInt(s);
            /*
                res 先左移 8 位
                再每个数使用 | 加入 res
             */
        }
        return res;
    }

    public String intToIp (long num) {
        String[] s = new String[4];
        for (int i = 0; i < 4; i++) {
            s[i] = String.valueOf(num & 255);
            /*
                255 是 8 位的 1
                取出后 8 位的1 形成一个数
                再 num 右移 8 位
             */
            num = num >> 8;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 3; i >= 1; i--) {
            res.append(s[i]).append('.');
        }
        res.append(s[0]);
        return res.toString();
    }


    public static void main(String[] args) {
        整数与IP地址间的转换 res = new 整数与IP地址间的转换();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            long num = in.nextLong();
            in.nextLine();
            System.out.println(res.ipToInt(ip));
            System.out.println(res.intToIp(num));
        }




    }
}
