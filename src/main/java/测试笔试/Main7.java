package 测试笔试;

import java.util.*;

/**
 * Title: Main7
 * Description:
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] arr = s.split(" ");
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[n - 1]);
    }
}
