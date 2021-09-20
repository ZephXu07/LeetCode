package 测试笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Title: Main8
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] arr = s.split(" ");
            Arrays.sort(arr);
            int i = 0;
            for(; i < arr.length - 1; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[i]);
            System.out.println();
        }

    }
}
