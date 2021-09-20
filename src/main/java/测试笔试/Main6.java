package 测试笔试;

import java.util.Scanner;

/**
 * Title: Main6
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] arr = line.split(" ");
            int res = 0;
            for (String s : arr) {
                res += Integer.parseInt(s);
            }
            System.out.println(res);
        }
    }
}
