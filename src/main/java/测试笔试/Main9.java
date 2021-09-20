package 测试笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Title: Main9
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] s = line.split(",");
            Arrays.sort(s);
            for(int i=0;i<s.length-1;i++){
                System.out.print(s[i] + ",");
            }
            System.out.println(s[s.length - 1]);
        }
    }
}
