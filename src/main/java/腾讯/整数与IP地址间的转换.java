package 腾讯;

import java.util.Scanner;

/**
 * Title: 整数与IP地址间的转换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-14
 */
public class 整数与IP地址间的转换 {

}

class Main {

    private final int N = 4;
    //ip地址四位
    public Main() {
    }

    public String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
                //简单粗暴，8位256，字符串转int
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N; i++) {
                result.insert(0, ipv4 % 256 + ".");
                //插入到开头，前面的被延后
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = main.convert(str);
            System.out.println(res);
        }
    }
}
