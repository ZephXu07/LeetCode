package 测试笔试;

import java.util.*;

/**
 * @author zeph
 */
public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long res = in.nextLong() + in.nextLong();
            System.out.println(res);
        }
    }

}
