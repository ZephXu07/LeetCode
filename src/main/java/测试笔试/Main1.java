package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main1
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        while (sum > 0) {
            int res = in.nextInt() + in.nextInt();
            System.out.println(res);
            sum--;
        }
    }
}
