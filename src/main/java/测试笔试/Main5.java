package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main5
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            int res = 0;
            for (int i = 0; i < len; i++) {
                res += in.nextInt();
            }
            System.out.println(res);
        }
    }
}
