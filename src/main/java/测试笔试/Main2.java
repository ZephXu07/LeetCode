package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }
}
