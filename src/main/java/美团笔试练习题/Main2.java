package 美团笔试练习题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Title: Main2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        List<Integer> scores = new ArrayList<>();
        while (in.hasNextInt()) {
            scores.add(in.nextInt());
        }

        Collections.sort(scores);


        int res = 0;
        for (int i = 0; i < scores.size(); i++) {
            res += (i + 1) - scores.get(i) ;
        }
        System.out.println(res);

    }
}
