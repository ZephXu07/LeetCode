package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main4
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (count > 0) {
            int len = in.nextInt();
            int res = 0;
            for (int i = 0; i < len; i++) {
                res += in.nextInt();
            }
            count--;
            System.out.println(res);
        }
    }
}
