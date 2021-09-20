package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main3
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        while (len != 0) {
            int res = 0;
            for (int i = 0; i < len; i++) {
                res += in.nextInt();
            }
            len = in.nextInt();
            System.out.println(res);
        }
    }
}
