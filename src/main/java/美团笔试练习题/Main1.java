package 美团笔试练习题;

import java.util.*;

/**
 * Title: Main
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        List<Integer> scores = new ArrayList<>();
        while (in.hasNextInt()) {
            scores.add(in.nextInt());
        }
        System.out.println(eliminate(scores, x, y, len));

    }

    private static int eliminate(List<Integer> scores, int x, int y, int len) {
        if (2 * y < len) {
            return -1;
        }
        if (2 * x > len) {
            return -1;
        }

        Collections.sort(scores);

        int promote = x;

        while (promote <= y) {
            int eliminate = len - promote;
            if (eliminate < x || eliminate > y) {
                promote++;
            } else {
                return scores.get(eliminate - 1);
            }
        }
        return -1;
    }

    private static int eliminate(int[] scores, int x, int y, int len) {
        if (2 * y < len) {
            return -1;
        }
        if (2 * x > len) {
            return -1;
        }

        Arrays.sort(scores);

        int promote = x;

        while (promote <= y) {
            int eliminate = len - promote;
            if (eliminate < x || eliminate > y) {
                promote++;
            } else {
                return scores[promote - 1];
            }
        }
        return -1;
    }

}
